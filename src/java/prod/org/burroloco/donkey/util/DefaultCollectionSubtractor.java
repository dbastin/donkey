package org.burroloco.donkey.util;

import java.util.ArrayList;
import java.util.List;

public class DefaultCollectionSubtractor implements CollectionSubtractor {

    public List subtract(List l1, List l2) {
        List result = new ArrayList(l1);
        for (Object o : l2) {
            result.remove(o);
        }
        return result;
    }
}