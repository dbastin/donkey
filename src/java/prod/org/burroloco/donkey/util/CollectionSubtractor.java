package org.burroloco.donkey.util;

import org.burroloco.donkey.data.cake.Slice;

import java.util.List;

public interface CollectionSubtractor {
    List<Slice> subtract(List<Slice> s1, List<Slice> s2);
}