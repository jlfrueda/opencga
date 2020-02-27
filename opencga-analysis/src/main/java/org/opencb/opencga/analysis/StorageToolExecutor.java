package org.opencb.opencga.analysis;

import org.apache.commons.lang3.StringUtils;
import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.opencga.analysis.alignment.AlignmentStorageManager;
import org.opencb.opencga.analysis.variant.manager.VariantStorageManager;
import org.opencb.opencga.catalog.exceptions.CatalogException;
import org.opencb.opencga.catalog.managers.CatalogManager;
import org.opencb.opencga.core.config.Configuration;
import org.opencb.opencga.core.exceptions.ToolExecutorException;
import org.opencb.opencga.storage.core.StorageEngineFactory;

import java.io.IOException;

/**
 * Helper interface to be used by opencga local analysis executors.
 */
public interface StorageToolExecutor {

    ObjectMap getExecutorParams();

    default VariantStorageManager getVariantStorageManager() throws ToolExecutorException {
        String opencgaHome = getExecutorParams().getString("opencgaHome");
        if (StringUtils.isEmpty(opencgaHome)) {
            throw new ToolExecutorException("Missing arguments!");
        }
        try {
            Configuration configuration = ConfigurationUtils.loadConfiguration(opencgaHome);
            CatalogManager catalogManager = new CatalogManager(configuration);
            StorageEngineFactory engineFactory = StorageEngineFactory.get();
            return new VariantStorageManager(catalogManager, engineFactory);
        } catch (CatalogException | IOException e) {
            throw new ToolExecutorException(e);
        }
    }

    default AlignmentStorageManager getAlignmentStorageManager() throws ToolExecutorException {
        String opencgaHome = getExecutorParams().getString("opencgaHome");
        if (StringUtils.isEmpty(opencgaHome)) {
            throw new ToolExecutorException("Missing arguments!");
        }
        try {
            Configuration configuration = ConfigurationUtils.loadConfiguration(opencgaHome);
            CatalogManager catalogManager = new CatalogManager(configuration);
            StorageEngineFactory engineFactory = StorageEngineFactory.get();
            return new AlignmentStorageManager(catalogManager, engineFactory);
        } catch (CatalogException | IOException e) {
            throw new ToolExecutorException(e);
        }
    }
}