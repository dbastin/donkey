package org.burroloco.donkey.input.database;

import edge.java.sql.ResultSet;

public class StringSliceValueHydrator implements SliceValueHydrator {
    public Object get(ResultSet resultSet, int i) {
        return resultSet.getString(i);
    }
}
