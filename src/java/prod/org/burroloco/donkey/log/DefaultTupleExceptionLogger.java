package org.burroloco.donkey.log;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.donkey.data.core.Tuple;

public class DefaultTupleExceptionLogger implements TupleExceptionLogger {
    ThrowableMaster chuckie;
    Log log;

    public void log(Tuple t, Exception e) {
        Throwable cause = chuckie.realCause(e);
        log.error("Problem encountered while processing: " + t, cause);
    }
}
