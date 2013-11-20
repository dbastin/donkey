package org.burroloco.donkey.converter;

import org.burroloco.donkey.data.core.Tuple;

public class DefaultUnitTupleToStringConverter implements UnitTupleToStringConverter {

    public String convert(Tuple t) {
        return (String) t.value(Tuple.UNIT_KEY);
    }
}
