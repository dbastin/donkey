package org.burroloco.donkey.output.file;

import org.burroloco.donkey.util.DirUtil;
import org.burroloco.donkey.util.FileStamper;

import java.io.File;

public class UniqueFileWizard implements FileWizard {
    FileStamper stampy;
    DirUtil files;

    public File file(String dirname, String filename, String ext) {
        File dir = files.makeDirs(dirname);
        String name = stampy.stamp(filename + "." + ext);
        return new File(dir, name);
    }
}