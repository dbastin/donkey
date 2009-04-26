package org.burroloco.donkey.job;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.listener.core.ErrorHandler;

// FIX DONKEY Should this be the default?
// FIX DONKEY You can control behaviour through Handler wiring. 
public class ErrorHandlingJob implements Job {
    ErrorHandler handle;
    Job delegate;

    public void go(Config config) {
        try {
            delegate.go(config);
        } catch (RuntimeException e) {
            handle.error(config, e);
        }
    }
}
