package org.burroloco.donkey.input.database;

import edge.java.sql.ResultSet;

public class DefaultSliceValueHydrator implements SliceValueHydrator {
    public Object get(ResultSet resultSet, int i) {
        return resultSet.getObject(i);
    }
}
