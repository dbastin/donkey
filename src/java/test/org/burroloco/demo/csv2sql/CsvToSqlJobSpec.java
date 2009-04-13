package org.burroloco.demo.csv2sql;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.core.OneLoop;
import org.burroloco.donkey.trebuchet.Loop;
import org.burroloco.donkey.trebuchet.JobSpec;
import org.burroloco.donkey.trebuchet.Wirer;

public class CsvToSqlJobSpec implements JobSpec {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/csv2sql.properties");
    }

    public Class<? extends Wirer> wirer() {
        return CsvToSqlWirer.class;
    }

    public Class<? extends Loop> loop() {
        return OneLoop.class;
    }
}
