package org.burroloco.donkey.job;

import au.net.netstorm.boost.gunge.lifecycle.Stop;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.PollingInterval;
import org.burroloco.util.snooze.Snoozer;

public class PollingJob implements Job, Stop {
    private boolean started = false;
    WeakConfig weak;
    Snoozer snoozer;
    Job delegate;

    public synchronized void go(Config config) {
        started = true;
        while (started) {
            delegate.go(config);
            snooze(config);
        }
    }

    public synchronized void stop() {
        started = false;
    }

    private void snooze(Config config) {
        Long interval = weak.get(config, PollingInterval.class);
        snoozer.snooze(interval);
    }
}
