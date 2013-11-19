package org.burroloco.donkey.slurp.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.sql.ResultSet;
import edge.java.sql.ResultSetMetaData;
import org.burroloco.donkey.data.core.Tuple;

import static org.burroloco.donkey.data.core.Null.NULL;

public class DefaultRowConverter implements RowConverter {
    ResultSetValues values;
    Nu nu;

    public Tuple convert(ResultSet resultSet) {
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
        Object value = values.get(resultSet, i);
        return handleNull(value);
    }

    private Object handleNull(Object value) {
        return value == null ? NULL : value;
    }
}
