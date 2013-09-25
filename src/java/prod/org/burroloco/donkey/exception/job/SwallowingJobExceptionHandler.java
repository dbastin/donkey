package org.burroloco.donkey.exception.job;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.log.ProcessLogger;

public class SwallowingJobExceptionHandler implements JobExceptionHandler {
    ProcessLogger logger;

    public void error(Config config, RuntimeException exception) {
        logger.logError(exception);
        swallow();
    }

    private void swallow() {
        // eeeeeeeeeeew.
    }
}
