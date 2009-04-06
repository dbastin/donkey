package org.burroloco.test.butcher.fixture.checker.tibco;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.test.util.poll.Poller;
import org.burroloco.test.util.poll.PollingBlock;

public class DefaultTibrvMsgChecker implements TibrvMsgChecker {
    private static final int TIMEOUT = 20;
    Poller poller;
    Impl impl;


    public void check(TibrvMsgHolder callback, String[] expectations) {
        if (!found(callback, expectations)) throw new RuntimeException("Too slow");
    }

    private boolean found(TibrvMsgHolder callback, String[] expectations) {
        PollingBlock checker = impl.impl(TibrvMsgCheckingPollingBlock.class, callback, expectations);
        return poller.call(checker, TIMEOUT);

    }
}
