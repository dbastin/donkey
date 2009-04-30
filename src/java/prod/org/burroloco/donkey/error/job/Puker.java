package org.burroloco.donkey.error.job;

import org.burroloco.config.core.Config;

public interface Puker {
    void error(Config config, RuntimeException exception);
}
