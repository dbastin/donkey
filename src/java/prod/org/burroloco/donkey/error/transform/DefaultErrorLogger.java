package org.burroloco.donkey.error.transform;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.donkey.data.core.Tuple;

public class DefaultErrorLogger implements ErrorLogger {
    ThrowableMaster chuckie;
    Log log;

    public void log(Tuple s, Exception e) {
        Throwable cause = chuckie.realCause(e);
        log.error("Problem encountered while processing: " + s, cause);
    }
}
