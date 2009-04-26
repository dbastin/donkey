package org.burroloco.donkey.transformation.error;

import org.burroloco.donkey.data.cake.Slice;

public interface Burper {
    void error(Slice slice, Exception e);
}
