package org.burroloco.donkey.error.gargle;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.donkey.data.core.Tuple;

public class DefaultGarglerExceptionHandler implements GarglerExceptionHandler {
    ThrowableMaster chuckie;
    ErrorLogger logger;

    public void handle(Tuple tuple, Exception e) {
        logger.log(tuple, e);
        Throwable cause = chuckie.realCause(e);
        chuckie.rethrow(cause);
    }
}
