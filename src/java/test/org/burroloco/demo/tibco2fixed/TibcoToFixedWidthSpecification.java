package org.burroloco.demo.tibco2fixed;

import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;

public class TibcoToFixedWidthSpecification implements Specification{
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/tibco2fixed.properties");
    }

    public Class<? extends Wirer> wirer() {
        return TibcoToFixedWidthWirer.class;
    }
}
