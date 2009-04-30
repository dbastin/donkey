package org.burroloco.donkey.error.job;

import org.burroloco.config.core.Config;

public class SwallowingPuker implements Puker {
    PukerLogger logger;

    public void error(Config config, RuntimeException exception) {
        logger.log(exception);
        swallow();
    }

    private void swallow() {
        // eeeeeeeeeeew.
    }
}
