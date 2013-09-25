package org.burroloco.donkey.exception.job;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.log.ProcessLogger;

public class DefaultJobExceptionHandler implements JobExceptionHandler {
    ThrowableMaster chuckie;
    ProcessLogger logger;

    public void error(Config config, RuntimeException exception) {
        logger.logError(exception);
        Throwable cause = chuckie.realCause(exception);
        chuckie.rethrow(cause);
    }
}
