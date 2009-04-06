package org.burroloco.test.butcher.fixture.checker.file;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.test.butcher.fixture.checker.type.Occurence;
import static org.burroloco.test.butcher.fixture.checker.type.Occurence.ONCE;
import org.burroloco.test.util.poll.Poller;
import org.burroloco.test.util.poll.PollingBlock;

import java.io.File;

public class DefaultPollingFileChecker implements PollingFileChecker {
    private static final int TIMEOUT = 20;
    FileUtilsStatic fileUtils;
    FileExistsPoller exists;
    FileChecker fileChecker;
    Poller poller;
    Impl impl;

    public void check(final File logFile, final String... expectations) {
        check(logFile, ONCE, expectations);
    }

    public void check(final File logFile, Occurence type, final String... expectations) {
        if (exists.check(logFile)) probe(logFile, type, expectations);
        else throw new RuntimeException("File not found: " + logFile);
    }

    private void probe(File file, Occurence type, String... expectations) {
        if (!found(file, type, expectations)) discoverWhy(file, type, expectations);
    }

    private boolean found(File file, Occurence type, String... contents) {
        PollingBlock checker = impl.impl(FileCheckingPollingBlock.class, file, type, contents);
        return poller.call(checker, TIMEOUT);
    }

    private void discoverWhy(File file, Occurence type, String[] expectations) {
        fileChecker.check(file, type, expectations);
    }


}
