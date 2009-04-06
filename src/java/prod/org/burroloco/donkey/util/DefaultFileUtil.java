package org.burroloco.donkey.util;

import edge.java.io.FileStatic;

import java.io.File;

public class DefaultFileUtil implements FileUtil {
    FileStatic fileStatic;

    public File makeDirs(String dirname) {
        return makeDirs(new File(dirname));
    }

    public File makeDirs(File dir) {
        dir.mkdirs();
        return dir;
    }

    public File createFile(String dirname, String prefix, String extension) {
        File dir = makeDirs(dirname);
        return new File(dir, prefix + "." + extension);
    }

    public File createUniqueFile(String dirname, String prefix, String extension) {
        File dir = makeDirs(dirname);
        return fileStatic.createTempFile(prefix, extension, dir);
    }

}
