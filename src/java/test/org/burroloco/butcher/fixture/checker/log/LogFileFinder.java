package org.burroloco.butcher.fixture.checker.log;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class LogFileFinder {

    public List<File> find() {
        List<File> result = new ArrayList<File>();
        Enumeration appenders = appenders();
        while (appenders.hasMoreElements()) {
            Appender a = (Appender) appenders.nextElement();
            if (a instanceof FileAppender) add(result, a);
        }
        return result;
    }

    private Enumeration appenders() {
        Logger logger = Logger.getRootLogger();
        return logger.getAllAppenders();
    }

    private void add(List<File> result, Appender a) {
        String fileName = ((FileAppender) a).getFile();
        result.add(new File(fileName));
    }
}
