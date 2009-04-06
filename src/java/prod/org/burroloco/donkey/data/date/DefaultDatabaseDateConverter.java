package org.burroloco.donkey.data.date;

import org.burroloco.donkey.input.database.DatabaseNull;
import org.burroloco.donkey.transformation.error.TransformException;
import org.burroloco.util.date.DateConverter;

public class DefaultDatabaseDateConverter implements DatabaseDateConverter {
    private static final String SYBASE = "yyyy-MM-dd HH:mm:ss.S";
    DateConverter converter;

    public Object convert(Object value) {
        if (value instanceof DatabaseNull) return value;
        if (value instanceof java.sql.Date) return converter.convert((java.sql.Date) value, SYBASE);
        throw new TransformException("Not a date: (" + value.getClass() + ") = " + value);
    }
}
