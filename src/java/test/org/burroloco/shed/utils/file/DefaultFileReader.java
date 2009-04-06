package org.burroloco.shed.utils.file;


import edge.org.apache.commons.io.FileUtilsStatic;

import java.io.File;

public class DefaultFileReader implements FileReader {
    FileUtilsStatic utils;

    public String read(File file) {
        return utils.readFileToString(file); 
    }

    public String read(String string) {
        File file = new File(string);
        return read(file);
    }
}
