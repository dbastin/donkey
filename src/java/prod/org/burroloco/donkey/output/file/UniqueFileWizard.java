package org.burroloco.donkey.output.file;

import org.burroloco.donkey.util.FileUtil;

import java.io.File;

// FIX TSR-DONKEY Use or Lose
public class UniqueFileWizard implements FileWizard {
    FileUtil fileUtil;

    public File file(String dirname, String prefix, String ext) {
        return fileUtil.createUniqueFile(dirname, prefix, ext);
    }
}