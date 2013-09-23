package org.burroloco.donkey.util;

import java.util.ArrayList;
import java.util.List;

public class DefaultCollectionSubtractor implements CollectionSubtractor {

    public List subtract(List minuend, List subtrahend) {
        List result = new ArrayList(minuend);
        for (Object o : subtrahend) {
            result.remove(o);
        }
        return result;
    }
}