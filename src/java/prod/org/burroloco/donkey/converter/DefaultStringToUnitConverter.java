package org.burroloco.donkey.converter;

import org.burroloco.donkey.data.core.DefaultTuple;
import org.burroloco.donkey.data.core.Tuple;

import static org.burroloco.donkey.data.core.Tuple.UNIT_KEY;

public class DefaultStringToUnitConverter implements StringToUnitConverter {

    public Tuple convert(String s) {
        Tuple t = new DefaultTuple();
        t.add(UNIT_KEY, s);
        return t;
    }
}
