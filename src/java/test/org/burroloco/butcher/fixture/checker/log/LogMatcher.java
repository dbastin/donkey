package org.burroloco.butcher.fixture.checker.log;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LogMatcher {

    private LogFileFinder logFiles = new LogFileFinder();
    private FileUtils files = new FileUtils();

    public boolean matches(String expected) {
        List<File> logs = logFiles.find();
        for (File log : logs) if (matches(expected, log)) return true;
        return false;
    }

    private boolean matches(String expected, File log) {
        String content = tryReadFile(log);
        String pattern = "(?ms).*" + expected + ".*";
        return content.matches(pattern);
    }

    private String tryReadFile(File log) {
        try {
            return files.readFileToString(log);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
