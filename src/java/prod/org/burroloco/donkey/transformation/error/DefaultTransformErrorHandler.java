package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultTransformErrorHandler implements TransformErrorHandler {
    TransformErrorLogger logger;
    ThrowableMaster chuckie;

    public void error(Slice slice, Exception e) {
        Throwable cause = chuckie.realCause(e);
        logger.log(slice, cause);
        chuckie.rethrow(cause);
    }
}
