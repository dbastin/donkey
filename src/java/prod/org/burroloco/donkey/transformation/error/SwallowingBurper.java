package org.burroloco.donkey.transformation.error;

import org.burroloco.donkey.data.cake.Slice;

public class SwallowingBurper implements Burper {
    public void error(Slice slice, Exception e) {
        // eeeeeeeeeeew.
    }
}
