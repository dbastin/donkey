package org.burroloco.tibco.config;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.trebuchet.Wirer;

public class DefaultTestTibcoWirer implements TestTibcoWirer {
    ConfigLoader loader;
    Impl impl;

    public void wire() {
        Config config = loader.load("config/tibco.properties");
        Wirer wirer = impl.impl(TibcoWirer.class);
        wirer.wire(config);
    }
}
