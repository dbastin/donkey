package org.burroloco.donkey.input.database;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;

public interface QueryRunnerEngine {
    Data query(Config config, String sqlStatement);
}
