package org.burroloco.donkey.slurp.csv;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;

import java.util.List;

public class DefaultListConverter implements ListConverter {
    Nu nu;

    public Data convert(List rows) {
        String[] headings = headings(rows);
        Data result = nu.nu(Data.class);
        addRows(result, headings, rows);
        result.readOnly();
        return result;
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

    private void addRows(Data result, String[] headings, List rows) {
        for (int i = 1; i < rows.size(); i++) {
            Object r = rows.get(i);
            Object[] values = (Object[]) r;
            create(result, headings, values);
        }
    }

    private void create(Data result, String[] colNames, Object[] values) {
        Tuple tuple = nu.nu(Tuple.class);
        addValues(tuple, values, colNames);
        tuple.readOnly();
        result.add(tuple);
    }

    private void addValues(Tuple tuple, Object[] values, String[] colNames) {
        for (int i = 0; i < values.length; i++) {
            String colName = colNames[i];
            Object value = values[i];
            tuple.add(colName, value);
        }
    }
}
