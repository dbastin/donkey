package org.burroloco.donkey.output.ice;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.data.error.UnsupportedTypeException;
import org.burroloco.donkey.input.database.DatabaseNull;

public class DefaultSqlIcer implements SqlIcer {
    Nu nu;

    public Cake transform(Cake in) {
        Cake iced = nu.nu(Cake.class);
        for (Slice slice : in.slices()) ice(iced, slice);
        return iced;
    }

    private void ice(Cake iced, Slice slice) {
        Slice newSlice = nu.nu(Slice.class);
        for (String name : slice.names()) ice(slice, newSlice, name);
        iced.add(newSlice);
    }

    private void ice(Slice slice, Slice newSlice, String name) {
        Object oldValue = slice.value(name);
        String newValue = convert(name, oldValue);
        newSlice.add(name, newValue);
    }

    private String convert(String name, Object value) {
        if (value instanceof DatabaseNull) return sqlNull();
        if (value instanceof String) return sqlString(value);
        throw new UnsupportedTypeException("Cannot convert value of type " + value.getClass() + " for '" + name + "'.");
    }

    private String sqlNull() {
        return "null";
    }

    private String sqlString(Object value) {
        return "'" + value + "'";
    }

}
