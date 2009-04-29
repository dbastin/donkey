package org.burroloco.donkey.error.transform;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultBurper implements Burper {
    ThrowableMaster chuckie;
    BurperLogger logger;

    public void error(Slice slice, Exception e) {
        logger.log(slice, e);
        Throwable cause = chuckie.realCause(e);
        chuckie.rethrow(cause);
    }
}
