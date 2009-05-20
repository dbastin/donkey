package org.burroloco.donkey.input.database;

import edge.java.sql.ResultSet;

public interface SliceValueHydrator {
    Object get(ResultSet resultSet, int i);
}
