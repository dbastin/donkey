package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.sql.ResultSet;
import edge.java.sql.ResultSetMetaData;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultSliceHydrater implements SliceHydrater {
    Nu nu;

    public Slice convertRow(ResultSet resultSet) {
        Slice slice = nu.nu(Slice.class);
        ResultSetMetaData metaData = resultSet.getMetaData();
        convert(resultSet, slice, metaData);
        return slice;
    }

    private void convert(ResultSet resultSet, Slice slice, ResultSetMetaData metaData) {
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            Object value = resultSet.getObject(i);
            slice.add(getColumnName(metaData, i), sanitize(value));
        }
    }

    private String getColumnName(ResultSetMetaData metaData, int i) {
        return metaData.getColumnLabel(i);
    }

    private Object sanitize(Object value) {
        Object result = handleNull(value);
        return trimStrings(value, result);
    }

    private Object trimStrings(Object value, Object result) {
        return result instanceof String ? trim((String) value) : result;
    }

    private Object trim(String value) {
        return value.trim();
    }

    private Object handleNull(Object value) {
        return value == null ? new DatabaseNull() : value;
    }
}
