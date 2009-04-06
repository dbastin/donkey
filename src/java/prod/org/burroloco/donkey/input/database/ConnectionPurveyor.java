package org.burroloco.donkey.input.database;

import edge.java.sql.Connection;
import org.burroloco.config.core.Config;

public interface ConnectionPurveyor {

    Connection connection(Config config);
}
