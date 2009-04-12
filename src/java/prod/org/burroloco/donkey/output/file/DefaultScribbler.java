package org.burroloco.donkey.output.file;

import edge.org.apache.commons.io.FileUtilsStatic;

import java.io.File;

public class DefaultScribbler implements Scribbler {
    FileUtilsStatic fileUtils;

    public void scribble(File file, String loogie) {
        fileUtils.writeStringToFile(file, loogie);
    }
}
