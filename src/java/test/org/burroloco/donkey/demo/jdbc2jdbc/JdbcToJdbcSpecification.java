package org.burroloco.donkey.demo.jdbc2jdbc;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;

public class JdbcToJdbcSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/jdbc2jdbc/jdbc2jdbc.properties");
    }

    public Class<? extends Wirer> wirer() {
        return JdbcToJdbcWirer.class;
    }
}
