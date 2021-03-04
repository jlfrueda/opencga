package org.opencb.opencga.storage.hadoop.variant.index.sample;

import htsjdk.variant.vcf.VCFConstants;
import org.opencb.biodata.models.variant.StudyEntry;
import org.opencb.opencga.storage.hadoop.variant.index.annotation.PopulationFrequencyIndex;
import org.opencb.opencga.storage.hadoop.variant.index.core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.opencb.opencga.storage.hadoop.variant.index.core.IndexFieldConfiguration.*;

/**
 * Sample index description. Used to build the sample index.
 */
public class SampleIndexConfiguration {

    private static final int DEFAULT_FILE_POSITION_SIZE_BITS = 4;
    private static final double[] QUAL_THRESHOLDS = new double[]{10, 20, 30};
    private static final double[] DP_THRESHOLDS = new double[]{5, 10, 15, 20, 30, 40, 50};

    private final List<PopulationFrequencyRange> populationRanges = new ArrayList<>();
    private final FileIndexConfiguration fileIndexConfiguration = new FileIndexConfiguration();

    private FileIndex fileIndex;
    private PopulationFrequencyIndex popFreqIndex;

    public SampleIndexConfiguration() {
    }

    public static SampleIndexConfiguration defaultConfiguration() {
        SampleIndexConfiguration sampleIndexConfiguration = new SampleIndexConfiguration()
                .addPopulationRange(new PopulationFrequencyRange("1kG_phase3", "ALL"))
                .addPopulationRange(new PopulationFrequencyRange("GNOMAD_GENOMES", "ALL"))
                .addFileIndexField(new IndexFieldConfiguration(
                        Source.FILE, StudyEntry.FILTER, Type.CATEGORICAL, VCFConstants.PASSES_FILTERS_v4))
                .addFileIndexField(new IndexFieldConfiguration(
                        Source.FILE, StudyEntry.QUAL, QUAL_THRESHOLDS))
                .addFileIndexField(new IndexFieldConfiguration(
                        Source.SAMPLE, VCFConstants.DEPTH_KEY, DP_THRESHOLDS));
        sampleIndexConfiguration.getFileIndexConfiguration().setFilePositionBits(DEFAULT_FILE_POSITION_SIZE_BITS);

        // Ensure backward compatibility with these two params:
        sampleIndexConfiguration.addFileIndexField(new IndexFieldConfiguration(
                Source.SAMPLE, "padding", Type.CATEGORICAL, "add_two_extra_bits", "to_allow_backward", "compatibility"));
        sampleIndexConfiguration.getFileIndexConfiguration().setFixedFieldsFirst(false);

        return sampleIndexConfiguration;
    }

    public List<PopulationFrequencyRange> getPopulationRanges() {
        return populationRanges;
    }

    public PopulationFrequencyIndex getPopFreqIndex() {
        if (popFreqIndex == null) {
            popFreqIndex = new PopulationFrequencyIndex(populationRanges);
        }
        return popFreqIndex;
    }

    public SampleIndexConfiguration addPopulationRange(PopulationFrequencyRange populationRange) {
        if (populationRanges.contains(populationRange)) {
            throw new IllegalArgumentException("Duplicated population '"
                    + populationRange.getStudyAndPopulation() + "' in SampleIndexConfiguration");
        }
        popFreqIndex = null;
        this.populationRanges.add(populationRange);
        return this;
    }

    public List<IndexFieldConfiguration> getFileIndexFieldsConfiguration() {
        return fileIndexConfiguration.customFields;
    }

    public FileIndexConfiguration getFileIndexConfiguration() {
        return fileIndexConfiguration;
    }

    public FileIndex getFileIndex() {
        if (fileIndex == null) {
            fileIndex = new FileIndex(this.getFileIndexConfiguration());
        }
        return fileIndex;
    }

    public SampleIndexConfiguration addFileIndexField(IndexFieldConfiguration fileIndex) {
        if (fileIndexConfiguration.customFields.contains(fileIndex)) {
            throw new IllegalArgumentException("Duplicated file index '"
                    + fileIndex.getKey() + "' in SampleIndexConfiguration");
        }
        this.fileIndex = null;
        this.fileIndexConfiguration.customFields.add(fileIndex);
        return this;
    }

    public static class FileIndexConfiguration {

        private final List<IndexFieldConfiguration> customFields = new ArrayList<>();
        private int filePositionBits = DEFAULT_FILE_POSITION_SIZE_BITS;
        private boolean fixedFieldsFirst = true;

        public FileIndexConfiguration() {
        }

        public FileIndexConfiguration(int filePositionBits, boolean fixedFieldsFirst) {
            this.filePositionBits = filePositionBits;
            this.fixedFieldsFirst = fixedFieldsFirst;
        }

        public List<IndexFieldConfiguration> getCustomFields() {
            return customFields;
        }

        public int getFilePositionBits() {
            return filePositionBits;
        }

        public FileIndexConfiguration setFilePositionBits(int filePositionBits) {
            this.filePositionBits = filePositionBits;
            return this;
        }

        public boolean isFixedFieldsFirst() {
            return fixedFieldsFirst;
        }

        public FileIndexConfiguration setFixedFieldsFirst(boolean fixedFieldsFirst) {
            this.fixedFieldsFirst = fixedFieldsFirst;
            return this;
        }
    }

    public static class PopulationFrequencyRange extends IndexFieldConfiguration {
        @Deprecated
        //TODO: This field should be private
        public static final double[] DEFAULT_THRESHOLDS = new double[]{0.001, 0.005, 0.01};
        private String study;
        private String population;

        public PopulationFrequencyRange(String studyPopulation) {
            super(Source.ANNOTATION, studyPopulation, DEFAULT_THRESHOLDS);
            this.study = studyPopulation.split(":")[0];
            this.population = studyPopulation.split(":")[1];
        }

        public PopulationFrequencyRange(String study, String population) {
            super(Source.ANNOTATION, study + ":" + population, DEFAULT_THRESHOLDS);
            this.study = study;
            this.population = population;
        }

        public String getStudy() {
            return study;
        }

        public String getStudyAndPopulation() {
            return study + ":" + population;
        }

        public PopulationFrequencyRange setStudy(String study) {
            this.study = study;
            return this;
        }

        public String getPopulation() {
            return population;
        }

        public PopulationFrequencyRange setPopulation(String population) {
            this.population = population;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PopulationFrequencyRange that = (PopulationFrequencyRange) o;
            return Objects.equals(study, that.study) && Objects.equals(population, that.population);
        }

        @Override
        public int hashCode() {
            return Objects.hash(study, population);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SampleIndexConfiguration that = (SampleIndexConfiguration) o;
        return Objects.equals(populationRanges, that.populationRanges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(populationRanges);
    }

}
