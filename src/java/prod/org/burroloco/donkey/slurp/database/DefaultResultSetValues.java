package org.burroloco.donkey.slurp.database;

import edge.java.sql.ResultSet;

public class DefaultResultSetValues implements ResultSetValues {
    public Object get(ResultSet resultSet, int i) {
        return resultSet.getObject(i);
    }
}
