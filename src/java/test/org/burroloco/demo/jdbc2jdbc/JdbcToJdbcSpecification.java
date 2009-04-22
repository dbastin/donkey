package org.burroloco.demo.jdbc2jdbc;

import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;

public class JdbcToJdbcSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/jdbc2jdbc.properties");
    }

    public Class<? extends Wirer> wirer() {
        return JdbcToJdbcWirer.class;
    }
}
