package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.bullet.log.Log;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultPuker implements Puker {
    Log log;
    public void puke(Slice slice, RuntimeException e) {
        log.error("This slice is awful: " + slice, e);
        throw e;
    }
}
