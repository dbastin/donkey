package org.burroloco.donkey.util;

import org.apache.commons.io.FilenameUtils;

public class DefaultFileStamper implements FileStamper {
    TimeStampCreator stampy;

    public String stamp(String fileName) {
        String baseName = FilenameUtils.getBaseName(fileName);
        String extension = FilenameUtils.getExtension(fileName);
        return baseName + "_" + stampy.getTimeStamp() + "." + extension;
    }
}
