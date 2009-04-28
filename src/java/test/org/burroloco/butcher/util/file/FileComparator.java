package org.burroloco.butcher.util.file;

import java.io.File;

public interface FileComparator {
    void assertEquals(File expected, File actual);
}
