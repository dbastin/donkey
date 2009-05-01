package org.burroloco.donkey.error.job;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.log.ProcessLogger;

public class SwallowingPuker implements Puker {
    ProcessLogger logger;

    public void error(Config config, RuntimeException exception) {
        logger.logError(exception);
        swallow();
    }

    private void swallow() {
        // eeeeeeeeeeew.
    }
}
