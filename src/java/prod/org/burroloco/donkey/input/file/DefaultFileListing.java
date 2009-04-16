package org.burroloco.donkey.input.file;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DefaultFileListing implements FileListing {

    public List<File> list(File dir) {
        if (!dir.isDirectory()) pop(dir);
        File[] files = dir.listFiles();
        return Arrays.asList(files);
    }

    private void pop(File file) {
        String invalid = file.getPath();
        throw new IllegalArgumentException(invalid + " is not a valid directory.");
    }
}
