package org.burroloco.donkey.log;

import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.test.constants.TestConstants;
import org.burroloco.test.util.io.FileWirer;

import java.io.File;

// FIX TSR-3629 Most tests should log to their own area or own prefix? NDC/MDC.
public class DefaultLogCleaner implements LogCleaner, TestConstants {
    FileUtilsStatic fileUtils;
    FileWirer file;

    public void clean() {
        clean(LOG);
    }

    public void clean(String filename) {
        File log = file.file(filename);
        clean(log);
    }

    public void clean(File log) {
        if (log.exists()) fileUtils.writeStringToFile(log, "");
    }

}
