package org.burroloco.donkey.slurp.database;

import edge.java.sql.ResultSet;

public class StringSliceValueHydrator implements SliceValueHydrator {
    public Object get(ResultSet resultSet, int i) {
        return resultSet.getString(i);
    }
}
