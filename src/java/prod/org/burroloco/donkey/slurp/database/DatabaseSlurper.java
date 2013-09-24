package org.burroloco.donkey.slurp.database;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.slurp.core.Slurper;

public final class DatabaseSlurper implements Slurper {
    QueryRunner runner;

    public Data slurp(Config config) {
        return runner.query(config);
    }
}