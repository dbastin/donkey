package org.burroloco.donkey.job;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.lifecycle.Stop;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.PollingInterval;
import org.burroloco.util.snooze.Snoozer;

public class Poller implements Job, Stop {
    private boolean started = false;
    WeakConfig weak;
    Snoozer snoozer;
    Job delegate;
    Log log;

    public void go(Config config) {
        init();
        while (started) {
            delegate.go(config);
            snooze(config);
        }
    }

    public void stop() {
        started = false;
        log.info("Poller stopped.");
    }

    private void init() {
        started = true;
        log.info("Poller started.");
    }

    private void snooze(Config config) {
        Long interval = weak.get(config, PollingInterval.class);
        snoozer.snooze(interval);
    }
}
