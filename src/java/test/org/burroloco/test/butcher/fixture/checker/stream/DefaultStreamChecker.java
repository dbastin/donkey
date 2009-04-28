package org.burroloco.test.butcher.fixture.checker.stream;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import edge.java.io.OutputStream;
import org.burroloco.test.butcher.fixture.checker.string.StringChecker;
import org.burroloco.test.butcher.util.poll.Poller;
import org.burroloco.test.butcher.util.poll.PollingBlock;

public class DefaultStreamChecker implements StreamChecker {
    private static final int TIMEOUT = 20;
    StringChecker checker;
    Poller poller;
    Impl impl;

    public void check(OutputStream out, String... expectations) {
        if (!found(out, expectations)) discoverWhy(out, expectations);
    }

    private boolean found(OutputStream out, String[] expectations) {
        PollingBlock checker = impl.impl(StreamCheckingPollingBlock.class, out, expectations);
        return poller.call(checker, TIMEOUT);
    }

    private void discoverWhy(OutputStream out, String[] expectations) {
        checker.check(out.toString(), expectations);
    }
}
