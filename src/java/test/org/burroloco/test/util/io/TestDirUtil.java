package org.burroloco.test.util.io;

import java.io.File;

public interface TestDirUtil {
    void assertDirSize(File dir, int expectedSize);

    void assertEmpty(File dir);

    void assertNotEmpty(File dir);
}
