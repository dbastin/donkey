package org.burroloco.donkey.demo.jdbc2http;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;

public class JdbcToHttpsSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/jdbc2https/jdbc2https.properties");
    }

    public Class<? extends Wirer> wirer() {
        return JdbcToHttpsWirer.class;
    }
}
