package org.burroloco.donkey.transformation.error;

import org.burroloco.donkey.data.cake.Slice;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.bullet.log.Log;

public class LoggingTransformPuker implements TransformPuker {
    TransformPuker delegate;
    ThrowableMaster chuckie;
    Log log;

    public void error(Slice slice, Exception e) {
        Throwable cause = chuckie.realCause(e);
        log.error("Bad data found during transform of: " + slice, cause);
        delegate.error(slice, e);
    }
}
