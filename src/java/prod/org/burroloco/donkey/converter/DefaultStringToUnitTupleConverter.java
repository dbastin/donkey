package org.burroloco.donkey.converter;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.core.Tuple;

import static org.burroloco.donkey.data.core.Tuple.UNIT_KEY;

public class DefaultStringToUnitTupleConverter implements StringToUnitTupleConverter {
    Nu nu;

    public Tuple unit(String s) {
        Tuple t = nu.nu(Tuple.class);
        t.add(UNIT_KEY, s);
        return t;
    }
}
