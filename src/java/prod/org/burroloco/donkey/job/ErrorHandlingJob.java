package org.burroloco.donkey.job;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.listener.core.ErrorHandler;

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
