package org.burroloco.donkey.input.database;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Data;

public interface QueryRunner {
    Data query(Config config);
}
