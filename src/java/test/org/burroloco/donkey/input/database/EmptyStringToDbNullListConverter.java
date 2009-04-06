package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.input.csv.ListConverter;
import static org.burroloco.donkey.input.database.DatabaseNull.DB_NULL;

import java.util.List;
import java.util.Set;

public class EmptyStringToDbNullListConverter implements ListConverter {

    ListConverter delegate;
    Nu nu;

    public Cake convert(List rows) {
        Cake cake = delegate.convert(rows);
        List<Slice> slices = cake.slices();
        Cake converted = nu.nu(Cake.class);
        for (Slice slice : slices) {
            convertSlice(converted, slice);
        }
        return converted;
    }

    private void convertSlice(Cake converted, Slice slice) {
        Slice newSlice = nu.nu(Slice.class);
        Set<String> cols = slice.names();
        for (String column : cols) {
            convertEmptyToDBNull(slice, newSlice, column);
        }
        converted.add(newSlice);
    }

    private void convertEmptyToDBNull(Slice slice, Slice newSlice, String column) {
        Object value = slice.value(column);
        if ("".equals(value)) {
            newSlice.add(column, DB_NULL);
        } else {
            newSlice.add(column, value);
        }
    }
}
