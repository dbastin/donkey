package org.burroloco.donkey.exception.job;

import org.burroloco.config.core.Config;

public interface JobExceptionHandler {
    void error(Config config, RuntimeException exception);
}
