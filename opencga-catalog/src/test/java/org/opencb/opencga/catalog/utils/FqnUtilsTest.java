package org.opencb.opencga.catalog.utils;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.opencb.opencga.core.testclassification.duration.ShortTests;

import static org.junit.Assert.*;

@Category(ShortTests.class)
public class FqnUtilsTest {

    @Test
    public void testFqnFull() {
        FqnUtils.FQN fqn = new FqnUtils.FQN("user@project:study");
        assertEquals("user", fqn.getUser());
        assertEquals("project", fqn.getProject());
        assertEquals("user@project", fqn.getProjectFqn());
        assertEquals("study", fqn.getStudy());
        assertEquals("user@project:study", fqn.toString());
    }

    @Test
    public void testFqnPartial() {
        FqnUtils.FQN fqn = new FqnUtils.FQN("user@project");
        assertEquals("user", fqn.getUser());
        assertEquals("project", fqn.getProject());
        assertEquals("user@project", fqn.getProjectFqn());
        assertEquals(null, fqn.getStudy());
        assertEquals("user@project", fqn.toString());
    }
}