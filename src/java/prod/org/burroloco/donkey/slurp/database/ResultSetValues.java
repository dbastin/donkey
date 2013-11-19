package org.burroloco.donkey.slurp.database;

import edge.java.sql.ResultSet;

public interface ResultSetValues {
    Object get(ResultSet resultSet, int i);
}
