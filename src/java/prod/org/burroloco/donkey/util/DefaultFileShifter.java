package org.burroloco.donkey.util;

import edge.org.apache.commons.io.FileUtilsStatic;

import java.io.File;

public class DefaultFileShifter implements FileShifter {
    FileUtilsStatic commons;
    FileStamper stampy;
    DirUtil dirUtil;

    public void stampAndMove(String sourceName, String targetDirName) {
        File source = new File(sourceName);
        File target = target(source.getName(), targetDirName);
        commons.moveFile(source, target);
    }

    private File target(String source, String targetDirName) {
        File targetDir = dirUtil.makeDirs(targetDirName);
        String target = stampy.stamp(source);
        return new File(targetDir, target);
    }
}
