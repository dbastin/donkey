package org.burroloco.butcher.fixture.checker.file;

import org.burroloco.butcher.exception.MissingExpectationException;
import org.burroloco.butcher.fixture.checker.type.Occurrence;
import org.burroloco.butcher.util.poll.PollingBlock;

import java.io.File;

public class FileCheckingPollingBlock implements PollingBlock {
    private final Occurrence type;
    private final String[] expectations;
    private final File file;
    FileChecker fileChecker;

    public FileCheckingPollingBlock(File file, Occurrence type, String... expectations) {
        this.file = file;
        this.type = type;
        this.expectations = expectations;
    }

    public boolean call() {
        try {
            fileChecker.check(file, type, expectations);
            return true;
        } catch (MissingExpectationException e) {
            return false;
        }
    }
}
