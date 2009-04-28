package org.burroloco.test.butcher.util.io;

import junit.framework.Assert;

import java.io.File;

public class DefaultTestDirUtil implements TestDirUtil {
    public void assertEmpty(File dir) {
        assertDirSize(dir, 0);
    }

    public void assertNotEmpty(File dir) {
        assertExists(dir);
        int size = dirSize(dir);
        Assert.assertEquals("Directory '" + dir + "' file count mismatch. Expected to be not empty but found " + size
                + " files", true, size > 0);
    }

    public void assertDirSize(File dir, int expectedSize) {
        assertExists(dir);
        assertSize(dir, expectedSize);
    }

    private void assertExists(File dir) {
        Assert.assertEquals("Directory '" + dir + "' does not exist", true, dir.exists());
    }

    private void assertSize(File dir, int expectedSize) {
        Assert.assertEquals("Directory '" + dir + "' file count mismatch", expectedSize, dirSize(dir));
    }

    private int dirSize(File dir) {
        return dir.listFiles().length;
    }
}
