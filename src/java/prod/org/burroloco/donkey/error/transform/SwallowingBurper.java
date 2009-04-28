package org.burroloco.donkey.error.transform;

import org.burroloco.donkey.data.cake.Slice;

public class SwallowingBurper implements Burper {
    public void error(Slice slice, Exception e) {
        // eeeeeeeeeeew.
    }
}
