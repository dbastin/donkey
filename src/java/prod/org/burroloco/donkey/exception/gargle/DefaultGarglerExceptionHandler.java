package org.burroloco.donkey.exception.gargle;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.log.TupleExceptionLogger;

public class DefaultGarglerExceptionHandler implements GarglerExceptionHandler {
    ThrowableMaster chuckie;
    TupleExceptionLogger logger;

    public void handle(Tuple tuple, Exception e) {
        logger.log(tuple, e);
        Throwable cause = chuckie.realCause(e);
        chuckie.rethrow(cause);
    }
}
