package org.burroloco.donkey.output.file;

import org.burroloco.donkey.util.FileUtil;

import java.io.File;

public class DefaultFileWizard implements FileWizard {
    FileUtil fileUtil;

    public File file(String dirname, String prefix, String ext) {
        return fileUtil.createFile(dirname, prefix, ext);
    }
}