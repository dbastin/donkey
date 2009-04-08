package org.burroloco.donkey.util;

import org.burroloco.donkey.data.cake.Slice;

import java.util.ArrayList;
import java.util.List;

public class DefaultCollectionSubtractor implements CollectionSubtractor {

    public List<Slice> subtract(List<Slice> s1, List<Slice> s2) {
        List<Slice> result = new ArrayList<Slice>(s1);
        for (Slice s : s2) {
            result.remove(s);
        }
        return result;
    }
}