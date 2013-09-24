package org.burroloco.donkey.slurp.database;

import edge.java.sql.ResultSet;
import org.burroloco.donkey.data.core.Data;

public interface DataHydrater {
    Data convert(ResultSet resultSet);
}
