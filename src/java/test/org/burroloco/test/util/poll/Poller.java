package org.burroloco.test.util.poll;

public interface Poller {
    boolean call(PollingBlock block);

    boolean call(PollingBlock block, long timeoutSecs);
}
