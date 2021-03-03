package org.opencb.opencga.storage.hadoop.variant.index.sample;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.opencb.biodata.models.variant.Variant;
import org.opencb.opencga.storage.core.io.bit.BitBuffer;

import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.opencb.biodata.models.variant.avro.VariantType.SNV;

public class SampleIndexEntryPutBuilderTest {

    @Test
    public void testContains() {
        SampleIndexEntryPutBuilder builder = new SampleIndexEntryPutBuilder(1, "1", 10, SampleIndexConfiguration.defaultConfiguration());

        builder.add("0/1", newVariantIndexEntry("1:100:A:C", (short) 20));
        builder.add("0/1", newVariantIndexEntry("1:200:A:C", (short) 20));
        builder.add("0/1", newVariantIndexEntry("1:200:A:C", (short) 30));
        builder.add("1/1", newVariantIndexEntry("1:300:A:C", (short) 20));
        builder.add("1/1", newVariantIndexEntry("1:400:A:C", (short) 20));

        assertTrue(builder.containsVariant(newVariantIndexEntry("1:100:A:C", (short) 30)));
        assertTrue(builder.containsVariant(newVariantIndexEntry("1:200:A:C", (short) 30)));
        assertTrue(builder.containsVariant(newVariantIndexEntry("1:300:A:C", (short) 30)));
        assertTrue(builder.containsVariant(newVariantIndexEntry("1:400:A:C", (short) 30)));

        assertFalse(builder.containsVariant(newVariantIndexEntry("1:50:A:C", (short) 30)));
        assertFalse(builder.containsVariant(newVariantIndexEntry("1:500:A:C", (short) 30)));
    }

    protected SampleVariantIndexEntry newVariantIndexEntry(String s, short i) {
        byte[] v = new byte[2];
        Bytes.putShort(v, 0, i);
        return new SampleVariantIndexEntry(new Variant(s), new BitBuffer(v));
    }

    @Test
    public void testBuild() {
        SampleIndexConfiguration configuration = SampleIndexConfiguration.defaultConfiguration();
        VariantFileIndexConverter c = new VariantFileIndexConverter(configuration);

        Put build = new SampleIndexEntryPutBuilder(1, "1", 10, configuration)
                .add("0/1", new SampleVariantIndexEntry(new Variant("1:100:A:C"), c.createFileIndexValue(SNV, 0, Collections.emptyMap(), Collections.emptyMap(), Collections.emptyList())))
                .add("0/1", new SampleVariantIndexEntry(new Variant("1:200:A:C"), c.createFileIndexValue(SNV, 1, Collections.emptyMap(), Collections.emptyMap(), Collections.emptyList())))
                .add("0/1", new SampleVariantIndexEntry(new Variant("1:200:A:C"), c.createFileIndexValue(SNV, 0, Collections.emptyMap(), Collections.emptyMap(), Collections.emptyList())))
                .add("1/1", new SampleVariantIndexEntry(new Variant("1:300:A:C"), c.createFileIndexValue(SNV, 0, Collections.emptyMap(), Collections.emptyMap(), Collections.emptyList())))
                .add("1/1", new SampleVariantIndexEntry(new Variant("1:400:A:C"), c.createFileIndexValue(SNV, 0, Collections.emptyMap(), Collections.emptyMap(), Collections.emptyList())))
                .build();


    }



}