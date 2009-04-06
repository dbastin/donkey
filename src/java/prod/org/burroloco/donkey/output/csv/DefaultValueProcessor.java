package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.input.database.DatabaseNull;

public class DefaultValueProcessor implements ValueProcessor {
    public String string(Object value) {
        if (value instanceof DatabaseNull) return "";
        return '"' + value.toString() + '"';
    }

}
