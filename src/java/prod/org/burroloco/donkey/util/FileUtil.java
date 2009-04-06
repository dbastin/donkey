package org.burroloco.donkey.util;

import java.io.File;

public interface FileUtil {
    File makeDirs(String dirname);

    File makeDirs(File dir);

    File createUniqueFile(String outputDirname, String prefix, String extension);

    File createFile(String outputDirname, String prefix, String extension);
}
