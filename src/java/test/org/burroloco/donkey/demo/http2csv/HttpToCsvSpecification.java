package org.burroloco.donkey.demo.http2csv;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;

public class HttpToCsvSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/http2csv/http2csv.properties");
    }

    public Class<? extends Wirer> wirer() {
        return HttpToCsvWirer.class;
    }
}
