package org.burroloco.test.butcher.fixture.checker.tibco;

import edge.com.tibco.tibrv.TibrvMsg;
import org.burroloco.test.butcher.exception.MissingExpectationException;
import org.burroloco.test.butcher.fixture.checker.string.StringChecker;
import org.burroloco.test.util.poll.PollingBlock;

public class TibrvMsgCheckingPollingBlock implements PollingBlock {
    private final TibrvMsgHolder holder;
    private final String[] expectations;
    StringChecker checker;

    public TibrvMsgCheckingPollingBlock(TibrvMsgHolder holder, String[] expectations) {
        this.holder = holder;
        this.expectations = expectations;
    }

    public boolean call() {
        try {
            TibrvMsg msg = holder.get();
            return check(msg);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean check(TibrvMsg msg) {
        try {
            checker.check(msg.toString(), expectations);
            return true;
        } catch (MissingExpectationException e) {
            return false;
        }
    }

}
