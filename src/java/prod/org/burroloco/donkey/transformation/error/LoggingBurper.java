package org.burroloco.donkey.transformation.error;

import org.burroloco.donkey.data.cake.Slice;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.bullet.log.Log;

public class LoggingBurper implements Burper {
    Burper delegate;
    ThrowableMaster chuckie;
    Log log;

    public void error(Slice slice, Exception e) {
        Throwable cause = chuckie.realCause(e);
        log.error("Bad data found while processing: " + slice, cause);
        delegate.error(slice, e);
    }
}
