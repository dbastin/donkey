package org.burroloco.donkey.input.database;

import edge.java.sql.ResultSet;
import org.burroloco.donkey.data.cake.Tuple;

public interface TupleHydrater {
    Tuple convertRow(ResultSet resultSet);
}
