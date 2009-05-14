package org.burroloco.donkey.input.csv;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;

import java.util.List;

public class DefaultListConverter implements ListConverter {
    Nu nu;

    public Cake convert(List rows) {
        String[] headings = headings(rows);
        Cake cake = nu.nu(Cake.class);
        addRows(headings, rows, cake);
        cake.refrigerate();
        return cake;
    }

    private String[] headings(List rows) {
        Object[] headings = (Object[]) rows.get(0);
        String[] results = new String[headings.length];
        for (int i = 0; i < headings.length; i++) {
            String heading = (String) headings[i];
            results[i] = heading;
        }
        return results;
    }

    private void addRows(String[] headings, List rows, Cake result) {
        for (int i = 1; i < rows.size(); i++) {
            Object r = rows.get(i);
            Object[] values = (Object[]) r;
            create(headings, values, result);
        }
    }

    private void create(String[] colNames, Object[] values, Cake result) {
        Slice slice = nu.nu(Slice.class);
        addValues(slice, values, colNames);
        result.add(slice);
    }

    private void addValues(Slice slice, Object[] values, String[] colNames) {
        for (int i = 0; i < values.length; i++) {
            String colName = colNames[i];
            Object value = values[i];
            slice.add(colName, value);
        }
    }
}
