package org.burroloco.demo.metadir2fixed;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;

public class MetaDirectoryToFixedWidthSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/metadir2fixed.properties");
    }

    public Class<? extends Wirer> wirer() {
        return MetaDirectoryToFixedWidthWirer.class;
    }
}
