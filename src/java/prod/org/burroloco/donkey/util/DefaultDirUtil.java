package org.burroloco.donkey.util;

import java.io.File;

public class DefaultDirUtil implements DirUtil {

    public File makeDirs(String dirname) {
        File dir = new File(dirname);
        dir.mkdirs();
        return dir;
    }
}
