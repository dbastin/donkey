package org.burroloco.demo.transform;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;

class TransformSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/transform.properties");
    }

    public Class<? extends Wirer> wirer() {
        return TransformWirer.class;
    }
}