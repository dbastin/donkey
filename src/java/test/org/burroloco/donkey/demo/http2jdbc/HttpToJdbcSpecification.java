package org.burroloco.donkey.demo.http2jdbc;

import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;

public class HttpToJdbcSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/http2jdbc/http2jdbc.properties");
    }

    public Class<? extends Wirer> wirer() {
        return HttpToJdbcWirer.class;
    }
}
