package org.burroloco.donkey.input.database;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Slice;

public interface SingleResultQuery {    
    Object value(Config config, String sqlStatement);
    Slice slice(Config config, String sqlStatement);
}
