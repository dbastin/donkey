package org.burroloco.test.butcher.util.file;

import java.io.File;

public interface FileComparator {
    void assertEquals(File expected, File actual);
}
