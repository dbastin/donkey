package org.burroloco.donkey.slurp.database;

import edge.java.sql.ResultSet;
import org.burroloco.donkey.data.core.Tuple;

public interface RowConverter {
    Tuple convert(ResultSet resultSet);
}
