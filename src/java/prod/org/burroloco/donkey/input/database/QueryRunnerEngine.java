package org.burroloco.donkey.input.database;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;

public interface QueryRunnerEngine {
    Cake query(Config config, String sqlStatement);
}
