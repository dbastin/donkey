package org.burroloco.donkey.log;

public interface ProcessLogger {
    void logStarted();

    void logFinished();

    void logError(RuntimeException exception);
}
