package org.burroloco.test.butcher.util.file;

import edge.org.apache.commons.io.FileUtilsStatic;

import java.io.File;

public class DefaultDosFileReader implements DosFileReader {
    FileUtilsStatic fileUtils;

    public String read(File report) {
        return fileUtils.readFileToString(report).replaceAll("\r", "");
    }
}
