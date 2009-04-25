package org.burroloco.demo.errors;

import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;

public class ErrorHandlingSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.overload("config/csv2sql.properties", "config/errors.properties");
    }

    public Class<? extends Wirer> wirer() {
        return ErrorHandlingWirer.class;
    }
}
