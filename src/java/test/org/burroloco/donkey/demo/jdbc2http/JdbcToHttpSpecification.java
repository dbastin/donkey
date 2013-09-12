package org.burroloco.donkey.demo.jdbc2http;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;

public class JdbcToHttpSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/jdbc2http/jdbc2http.properties");
    }

    public Class<? extends Wirer> wirer() {
        return JdbcToHttpWirer.class;
    }
}
