package org.burroloco.donkey.job;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.listener.core.Puker;

// FIX DONKEY Should this be the default?
// FIX DONKEY You can control behaviour through Puker wiring. 
public class PukingJob implements Job {
    Job delegate;
    Puker puker;

    public void go(Config config) {
        try {
            delegate.go(config);
        } catch (RuntimeException e) {
            puker.error(config, e);
        }
    }
}
