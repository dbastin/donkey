package org.burroloco.donkey.error.job;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.config.core.Config;

public class DefaultPuker implements Puker {
    ThrowableMaster chuckie;
    PukerLogger logger;

    public void error(Config config, RuntimeException exception) {
        logger.log(exception);
        Throwable cause = chuckie.realCause(exception);
        chuckie.rethrow(cause);
    }
}
