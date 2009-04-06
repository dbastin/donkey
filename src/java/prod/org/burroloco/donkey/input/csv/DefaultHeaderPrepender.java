package org.burroloco.donkey.input.csv;

import java.util.ArrayList;
import java.util.List;

public class DefaultHeaderPrepender implements HeaderPrepender {
    public List prepend(List rows) {
        check(rows);
        String[] exampleRow = (String[]) rows.get(0);
        String[] header = makeHeader(exampleRow.length);
        return prepend(header, rows);
    }

    private void check(List rows) {
        if (rows.size() == 0) throw new IllegalArgumentException("Can't prepend to empty list of rows.");
    }

    private String[] makeHeader(int columns) {
        String[] header = new String[columns];
        for (int i = 0; i < columns; i++) {
            header[i] = someColumnName(i);
        }
        return header;
    }

    private List prepend(Object element, List list) {
        List result = new ArrayList();
        result.add(element);
        result.addAll(list);
        return result;
    }

    private String someColumnName(int i) {
        return i + "";
    }
}
