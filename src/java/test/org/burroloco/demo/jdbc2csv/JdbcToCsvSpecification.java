package org.burroloco.demo.jdbc2csv;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.loop.Loop;
import org.burroloco.donkey.loop.SimpleLoop;
import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;

public class JdbcToCsvSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/jdbc2csv.properties");
    }

    public Class<? extends Wirer> wirer() {
        return JdbcToCsvWirer.class;
    }

    public Class<? extends Loop> loop() {
        return SimpleLoop.class;
    }
}
