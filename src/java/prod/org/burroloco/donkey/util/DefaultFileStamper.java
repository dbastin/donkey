package org.burroloco.donkey.util;

import org.apache.commons.io.FilenameUtils;

public class DefaultFileStamper implements FileStamper {

    TimeStampCreator stampy;

    public String stamp(String fileName) {
        String baseName = FilenameUtils.getBaseName(fileName);
        String extension = FilenameUtils.getExtension(fileName);
        // TODO - Hmmmm. Might not be unique enough if used for error processing.
        return baseName + "-" + stampy.getTimeStamp() + "." + extension;
    }
}
