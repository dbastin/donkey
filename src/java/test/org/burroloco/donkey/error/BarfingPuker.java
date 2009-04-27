package org.burroloco.donkey.error;

import org.burroloco.donkey.error.listener.core.Puker;
import org.burroloco.config.core.Config;

public class BarfingPuker implements Puker {
    public void error(Config config, Exception exception) {
        throw new RuntimeException("Something terrible happened while puking.");
    }
}
