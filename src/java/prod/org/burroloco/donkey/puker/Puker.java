package org.burroloco.donkey.puker;

import org.burroloco.config.core.Config;

public interface Puker {
    void error(Config config, Exception exception);
}
