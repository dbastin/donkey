package org.burroloco.donkey.input.database;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Data;
import org.burroloco.donkey.input.core.Slurper;

public final class DatabaseSlurper implements Slurper {
    QueryRunner runner;

    public Data slurp(Config config) {
        return runner.query(config);
    }
}