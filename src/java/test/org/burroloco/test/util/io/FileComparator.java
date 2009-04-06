package org.burroloco.test.util.io;

import java.io.File;

public interface FileComparator {
    void assertEquals(File expected, File actual);
}
