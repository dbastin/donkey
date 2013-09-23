package org.burroloco.donkey.error.transform;

import org.burroloco.donkey.data.core.Tuple;

public class LoggingExceptionHandler implements ExceptionHandler {
    ErrorLogger logger;

    public void handle(Tuple tuple, Exception e) {
        logger.log(tuple, e);
    }

}
