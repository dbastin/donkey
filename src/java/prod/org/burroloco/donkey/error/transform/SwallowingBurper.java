package org.burroloco.donkey.error.transform;

import org.burroloco.donkey.data.cake.Slice;

public class SwallowingBurper implements Burper {
    BurperLogger logger;

    public void error(Slice slice, Exception e) {
        logger.log(slice, e);
        swallow();
    }

    private void swallow() {
        // eeeeeeeeeeew.
    }
}
