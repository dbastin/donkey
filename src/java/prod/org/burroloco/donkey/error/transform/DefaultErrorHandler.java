package org.burroloco.donkey.error.transform;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.donkey.data.core.Tuple;

public class DefaultErrorHandler implements ErrorHandler {
    ThrowableMaster chuckie;
    ErrorLogger logger;

    public void handle(Tuple tuple, Exception e) {
        logger.log(tuple, e);
        Throwable cause = chuckie.realCause(e);
        chuckie.rethrow(cause);
    }
}
