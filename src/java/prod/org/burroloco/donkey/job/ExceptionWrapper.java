package org.burroloco.donkey.job;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.exception.job.JobExceptionHandler;

public class ExceptionWrapper implements Job {
    Job delegate;
    JobExceptionHandler exceptions;

    public void go(Config config) {
        try {
            delegate.go(config);
        } catch (RuntimeException e) {
            exceptions.error(config, e);
        }
    }
}
