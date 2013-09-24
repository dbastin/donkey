package org.burroloco.donkey.slurp.database;

import edge.java.sql.ResultSet;

public interface SliceValueHydrator {
    Object get(ResultSet resultSet, int i);
}
