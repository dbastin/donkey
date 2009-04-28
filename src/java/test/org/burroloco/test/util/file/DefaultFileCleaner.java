package org.burroloco.test.util.file;

import edge.org.apache.commons.io.FileUtilsStatic;

import java.io.File;

public class DefaultFileCleaner implements FileCleaner {
    FileUtilsStatic fileUtils;

    public void clean(File file) {
        if (file.exists()) fileUtils.writeStringToFile(file, "");
    }
}
