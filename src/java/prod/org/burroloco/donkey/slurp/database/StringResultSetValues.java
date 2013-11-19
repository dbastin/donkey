package org.burroloco.donkey.slurp.database;

import edge.java.sql.ResultSet;

public class StringResultSetValues implements ResultSetValues {
    public Object get(ResultSet resultSet, int i) {
        return resultSet.getString(i);
    }
}
