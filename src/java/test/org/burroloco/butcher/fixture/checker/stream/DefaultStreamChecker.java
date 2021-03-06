package org.burroloco.butcher.fixture.checker.stream;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import edge.java.io.OutputStream;
import org.burroloco.butcher.fixture.checker.string.StringChecker;
import org.burroloco.butcher.util.poll.Poller;
import org.burroloco.butcher.util.poll.PollingBlock;

public class DefaultStreamChecker implements StreamChecker {
    private static final int TIMEOUT = 20;
    StringChecker checker;
    Poller poller;
    Impl impl;

    public void check(OutputStream out, String... expectations) {
        if (!found(out, expectations)) discoverWhy(out, expectations);
    }

    private boolean found(OutputStream out, String[] expectations) {
        PollingBlock checker = impl.impl(PollingBlock.class, StreamCheckingPollingBlock.class, out, expectations);
        return poller.call(checker, TIMEOUT);
    }

    private void discoverWhy(OutputStream out, String[] expectations) {
        checker.check(out.toString(), expectations);
    }
}
