package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.sql.ResultSet;
import edge.java.sql.ResultSetMetaData;
import org.burroloco.donkey.data.core.Tuple;

public class DefaultTupleHydrater implements TupleHydrater {
    SliceValueHydrator valueHydrator;
    Nu nu;

    public Tuple convertRow(ResultSet resultSet) {
        Tuple tuple = nu.nu(Tuple.class);
        ResultSetMetaData metaData = resultSet.getMetaData();
        convert(resultSet, tuple, metaData);
        return tuple;
    }

    private void convert(ResultSet resultSet, Tuple tuple, ResultSetMetaData metaData) {
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            String name = getName(metaData, i);
            Object value = getValue(resultSet, i);
            tuple.add(name, value);
        }
    }

    private String getName(ResultSetMetaData metaData, int i) {
        return metaData.getColumnLabel(i);
    }

    private Object getValue(ResultSet resultSet, int i) {
        Object value = valueHydrator.get(resultSet, i);
        return handleNull(value);
    }

    private Object handleNull(Object value) {
        return value == null ? new DatabaseNull() : value;
    }
}
