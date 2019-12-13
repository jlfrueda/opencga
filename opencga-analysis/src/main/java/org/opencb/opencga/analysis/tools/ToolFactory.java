package org.opencb.opencga.analysis.tools;

import org.apache.commons.lang3.StringUtils;
import org.opencb.opencga.core.annotations.Tool;
import org.opencb.opencga.core.exception.ToolException;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Modifier;
import java.util.*;

public class ToolFactory {
    private static final Logger logger = LoggerFactory.getLogger(ToolFactory.class);
    private static Map<String, Class<? extends OpenCgaTool>> toolsCache;
    private static Map<String, Set<Class<? extends OpenCgaTool>>> duplicatedTools;

    private static synchronized Map<String, Class<? extends OpenCgaTool>> loadTools() {
        if (toolsCache == null) {
            Reflections reflections = new Reflections(new ConfigurationBuilder()
                    .setScanners(
                            new SubTypesScanner(),
                            new TypeAnnotationsScanner().filterResultsBy(s -> StringUtils.equals(s, Tool.class.getName()))
                    )
                    .addUrls(ClasspathHelper.forJavaClassPath())
                    .filterInputsBy(input -> input != null && input.endsWith(".class"))
            );

            Map<String, Set<Class<? extends OpenCgaTool>>> duplicatedTools = new HashMap<>();
            Set<Class<? extends OpenCgaTool>> subTypes = reflections.getSubTypesOf(OpenCgaTool.class);
            Map<String, Class<? extends OpenCgaTool>> cache = new HashMap<>();
            for (Class<? extends OpenCgaTool> subType : subTypes) {
                Tool annotation = subType.getAnnotation(Tool.class);
                if (annotation != null) {
                    Class<? extends OpenCgaTool> old = cache.put(annotation.id(), subType);
                    if (old != null) {
                        Set<Class<? extends OpenCgaTool>> set = duplicatedTools.computeIfAbsent(annotation.id(), k -> new HashSet<>());
                        set.add(old);
                        set.add(subType);
                    }
                } else if (!Modifier.isAbstract(subType.getModifiers())) {
                    logger.warn("Found non-abstract class " + subType.getName() + " extending " + OpenCgaTool.class.getSimpleName()
                            + " without the java annotation @" + Tool.class.getSimpleName());
                }
            }
            if (!duplicatedTools.isEmpty()) {
                duplicatedTools.forEach((id, set) -> {
                    cache.remove(id);
                    logger.error("Found duplicated tool ID '{}' in classes {}", id, set);
                });
                duplicatedTools.replaceAll((key, set) -> Collections.unmodifiableSet(set));
            }
            ToolFactory.duplicatedTools = Collections.unmodifiableMap(duplicatedTools);
            ToolFactory.toolsCache = cache;
        }
        return toolsCache;
    }

    public final Class<? extends OpenCgaTool> getToolClass(String toolId) throws ToolException {
        Objects.requireNonNull(toolId);

        Class<? extends OpenCgaTool> aClass = null;
        try {
            Class<?> inputClass = Class.forName(toolId);
            if (OpenCgaTool.class.isAssignableFrom(inputClass)) {
                aClass = (Class<? extends OpenCgaTool>) inputClass;
            }
        } catch (ClassNotFoundException ignore) {
        }
        if (aClass == null) {
            aClass = loadTools().get(toolId);
        }
        if (aClass == null) {
            throw new ToolException("Tool '" + toolId + "' not found");
        }
        return aClass;
    }

    public final OpenCgaTool getTool(String toolId) throws ToolException {
        return getTool(getToolClass(toolId));
    }

    public final OpenCgaTool getTool(Class<? extends OpenCgaTool> aClass) throws ToolException {
        Tool annotation = aClass.getAnnotation(Tool.class);
        if (annotation == null) {
            throw new ToolException("Class " + aClass + " does not have the required java annotation @" + Tool.class.getSimpleName());
        }
        try {
            return aClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ToolException("Can't instantiate class " + aClass + " from tool '" + annotation.id() + "'", e);
        }
    }


    public Collection<Class<? extends OpenCgaTool>> getTools() {
        List<Class<? extends OpenCgaTool>> values = new ArrayList<>(loadTools().values());
        values.sort(Comparator.comparing((Class<? extends OpenCgaTool> c) -> c.getAnnotation(Tool.class).type())
                .thenComparing(c -> c.getAnnotation(Tool.class).id()));
        return values;
    }

    public Map<String, Set<Class<? extends OpenCgaTool>>> getDuplicatedTools() {
        loadTools();
        return duplicatedTools;
    }
}