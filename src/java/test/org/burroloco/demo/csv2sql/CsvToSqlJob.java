package org.burroloco.demo.csv2sql;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.core.OneLoop;
import org.burroloco.donkey.trebuchet.Loop;
import org.burroloco.donkey.trebuchet.Job;
import org.burroloco.donkey.trebuchet.Wirer;

public class CsvToSqlJob implements Job {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/csv2sql.properties");
    }

    public Class<? extends Wirer> wirer() {
        return CsvToSqlWirer.class;
    }

    public Class<? extends Loop> looping() {
        return OneLoop.class;
    }
}
