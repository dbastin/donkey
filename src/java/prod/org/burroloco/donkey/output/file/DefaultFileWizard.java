package org.burroloco.donkey.output.file;

import org.burroloco.donkey.util.DirUtil;

import java.io.File;

public class DefaultFileWizard implements FileWizard {
    DirUtil dirUtil;

    public File file(String dirname, String prefix, String ext) {
        File dir = dirUtil.makeDirs(dirname);
        return new File(dir, prefix + "." + ext);
    }
}