package org.burroloco.donkey.util;

import edge.java.io.FileStatic;

import java.io.File;

public class DefaultDirUtil implements DirUtil {
    FileStatic fileStatic;

    public File makeDirs(String dirname) {
        File dir = new File(dirname);
        dir.mkdirs();
        return dir;
    }
}
