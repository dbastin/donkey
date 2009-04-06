package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.ArrayList;
import java.util.List;

public class DefaultDatabaseNullConverter implements DatabaseNullConverter {
    Nu nu;

    public List convert(List innies) {
        List outies = new ArrayList();
        for (Object innieRow : innies) {
            Object[] outieRow = processValues((String[]) innieRow);
            outies.add(outieRow);
        }
        return outies;
    }

    private Object[] processValues(String[] innieRow) {
        Object[] outieRow = new Object[innieRow.length];
        for (int i = 0; i < innieRow.length; i++) {
            String s = innieRow[i];
            if (s == null || s.length() == 0) outieRow[i] = new DatabaseNull();
            else outieRow[i] = s;
        }
        return outieRow;
    }

}
