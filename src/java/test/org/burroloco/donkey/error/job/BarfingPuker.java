package org.burroloco.donkey.error.job;

import org.burroloco.config.core.Config;

public class BarfingPuker implements Puker {
    public void error(Config config, Exception exception) {
        throw new RuntimeException("Something terrible happened while puking.");
    }
}
