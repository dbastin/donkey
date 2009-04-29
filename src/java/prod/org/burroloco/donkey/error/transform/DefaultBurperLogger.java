package org.burroloco.donkey.error.transform;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultBurperLogger implements BurperLogger {
    ThrowableMaster chuckie;
    Log log;

    public void log(Slice s, Exception e) {
        Throwable cause = chuckie.realCause(e);
        log.error("Problem encountered while processing: " + s, cause);
    }
}
