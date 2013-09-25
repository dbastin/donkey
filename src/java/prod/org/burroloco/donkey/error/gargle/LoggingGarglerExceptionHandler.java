package org.burroloco.donkey.error.gargle;

import org.burroloco.donkey.data.core.Tuple;

public class LoggingGarglerExceptionHandler implements GarglerExceptionHandler {
    ErrorLogger logger;

    public void handle(Tuple tuple, Exception e) {
        logger.log(tuple, e);
    }

}
