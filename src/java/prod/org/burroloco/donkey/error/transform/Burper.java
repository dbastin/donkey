package org.burroloco.donkey.error.transform;

import org.burroloco.donkey.data.cake.Slice;

public interface Burper {
    void error(Slice slice, Exception e);
}
