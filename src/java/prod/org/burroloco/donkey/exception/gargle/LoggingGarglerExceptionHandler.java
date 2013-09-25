package org.burroloco.donkey.exception.gargle;

import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.log.TupleExceptionLogger;

public class LoggingGarglerExceptionHandler implements GarglerExceptionHandler {
    TupleExceptionLogger logger;

    public void handle(Tuple tuple, Exception e) {
        logger.log(tuple, e);
    }

}
