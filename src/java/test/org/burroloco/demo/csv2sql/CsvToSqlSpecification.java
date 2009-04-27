package org.burroloco.demo.csv2sql;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;

public class CsvToSqlSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/csv2sql/csv2sql.properties");
    }

    public Class<? extends Wirer> wirer() {
        return CsvToSqlWirer.class;
    }
}
