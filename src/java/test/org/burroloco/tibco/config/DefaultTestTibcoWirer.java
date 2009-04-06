package org.burroloco.tibco.config;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.trebuchet.ConfigWirer;

public class DefaultTestTibcoWirer implements TestTibcoWirer {
    ConfigLoader loader;
    ConfigWirer wirer;

    public void wire() {
        Config config = loader.load("config/tibco.properties");
        wirer.wire(config, TibcoWirer.class);
    }
}
