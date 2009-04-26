package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultTransformPuker implements TransformPuker {
    ThrowableMaster chuckie;

    public void error(Slice slice, Exception e) {
        Throwable cause = chuckie.realCause(e);
        chuckie.rethrow(cause);
    }
}
