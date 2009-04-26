package org.burroloco.donkey.error.listener.core;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.bullet.log.Log;
import org.burroloco.config.core.Config;

public class DefaultErrorHandler implements ErrorHandler {
    ThrowableMaster chuckie;
    Log log;

    public void error(Config config, Exception exception) {
        Throwable cause = chuckie.rootCause(exception);
        log.error(cause);
        chuckie.rethrow(cause);
    }
}
