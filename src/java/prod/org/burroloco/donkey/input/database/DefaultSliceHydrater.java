package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.sql.ResultSet;
import edge.java.sql.ResultSetMetaData;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultSliceHydrater implements SliceHydrater {
    SliceValueHydrator valueHydrator;
    Nu nu;

    public Slice convertRow(ResultSet resultSet) {
        Slice slice = nu.nu(Slice.class);
        ResultSetMetaData metaData = resultSet.getMetaData();
        convert(resultSet, slice, metaData);
        return slice;
    }

    private void convert(ResultSet resultSet, Slice slice, ResultSetMetaData metaData) {
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            String name = getName(metaData, i);
            Object value = getValue(resultSet, i);
            slice.add(name, value);
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
