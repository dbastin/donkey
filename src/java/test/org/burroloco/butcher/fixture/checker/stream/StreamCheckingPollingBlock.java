package org.burroloco.butcher.fixture.checker.stream;

import edge.java.io.OutputStream;
import org.burroloco.butcher.exception.MissingExpectationException;
import org.burroloco.butcher.fixture.checker.string.StringChecker;
import org.burroloco.butcher.util.poll.PollingBlock;

public class StreamCheckingPollingBlock implements PollingBlock {
    private final String[] expectations;
    private final OutputStream out;
    StringChecker checker;

    public StreamCheckingPollingBlock(OutputStream out, String[] expectations) {
        this.out = out;
        this.expectations = expectations;
    }

    public boolean call() {
        try {
            checker.check(out.toString(), expectations);
            return true;
        } catch (MissingExpectationException e) {
            return false;
        }
    }
}
