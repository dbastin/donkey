package org.burroloco.test.butcher.util.poll;

public interface Poller {
    boolean call(PollingBlock block);

    boolean call(PollingBlock block, long timeoutSecs);
}
