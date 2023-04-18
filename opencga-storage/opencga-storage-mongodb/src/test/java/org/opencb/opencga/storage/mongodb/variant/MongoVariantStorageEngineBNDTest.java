package org.opencb.opencga.storage.mongodb.variant;

import org.junit.experimental.categories.Category;
import org.opencb.opencga.core.testclassification.duration.ShortTests;
import org.opencb.opencga.storage.core.variant.VariantStorageEngineBNDTest;

/**
 * Created on 14/09/17.
 *
 * @author Jacobo Coll &lt;jacobo167@gmail.com&gt;
 */
@Category(ShortTests.class)
public class MongoVariantStorageEngineBNDTest extends VariantStorageEngineBNDTest implements MongoDBVariantStorageTest {
}
