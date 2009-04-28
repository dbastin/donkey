package org.burroloco.donkey.error.transform;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.donkey.data.cake.Slice;

public class LoggingBurper implements Burper {
    Burper delegate;
    ThrowableMaster chuckie;
    Log log;

    public void error(Slice slice, Exception e) {
        Throwable cause = chuckie.realCause(e);
        log.error("Problem encountered while processing: " + slice, cause);
        delegate.error(slice, e);
    }
}
