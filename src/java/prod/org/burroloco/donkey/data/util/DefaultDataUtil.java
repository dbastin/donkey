package org.burroloco.donkey.data.util;

import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;

import java.util.List;

public class DefaultDataUtil implements DataUtil {

    public Object singleValue(Data d) {
        List<Tuple> t = d.tuples();
        Tuple first = t.get(0);
        return first.values().get(0);
    }
}
