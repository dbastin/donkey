package org.burroloco.donkey.error.job;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.log.ProcessLogger;

public class DefaultPuker implements Puker {
    ThrowableMaster chuckie;
    ProcessLogger logger;

    public void error(Config config, RuntimeException exception) {
        logger.logError(exception);
        Throwable cause = chuckie.realCause(exception);
        chuckie.rethrow(cause);
    }
}
