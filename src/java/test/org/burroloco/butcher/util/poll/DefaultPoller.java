package org.burroloco.butcher.util.poll;

import org.burroloco.donkey.glue.constants.TestConstants;
import org.burroloco.util.snooze.Snoozer;

public class DefaultPoller implements Poller, TestConstants {
    public static final long TIMEOUT_SECS = 180;
    Snoozer snoozer;

    public boolean call(PollingBlock block) {
        return call(block, TIMEOUT_SECS);
    }

    public boolean call(PollingBlock block, long timeoutSecs) {
        long endTime = currentTime() + timeoutSecs * ONE_SECOND;
        while (currentTime() < endTime) {
            if (block.call()) return true;
            snoozer.snooze(100);
        }
        return false;
    }

    private long currentTime() {
        return System.currentTimeMillis();
    }
}