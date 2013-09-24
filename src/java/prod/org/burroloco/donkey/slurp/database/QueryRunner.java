package org.burroloco.donkey.slurp.database;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;

public interface QueryRunner {
    Data query(Config config);
}
