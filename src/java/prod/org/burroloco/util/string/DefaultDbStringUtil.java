package org.burroloco.util.string;

import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.input.database.DatabaseNull;

public class DefaultDbStringUtil implements DbStringUtil {

    public String concatColumns(Slice in, String... columns) {
        StringBuilder builder = new StringBuilder();
        for (String column : columns) {
            Object value = in.value(column);
            if (!(value instanceof DatabaseNull)) {
                builder.append(builder.length() > 0 ? " " + value : value);
            }
        }
        return builder.toString().trim();
    }
}
