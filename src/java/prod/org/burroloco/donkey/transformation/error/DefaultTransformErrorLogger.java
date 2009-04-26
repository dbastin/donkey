package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.bullet.log.Log;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultTransformErrorLogger implements TransformErrorLogger {
    Log log;

    public void log(Slice slice, Throwable cause) {
        log.error("Bad data found during transform of: " + slice, cause);
    }
}
