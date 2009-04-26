package org.burroloco.donkey.error.listener.core;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.config.core.Config;

public class ProtectingErrorHandler implements ErrorHandler {
    ThrowableMaster chuckie;
    ErrorHandler delegate;
    Log log;

    public void error(Config config, Exception e) {
        try {
            delegate.error(config, e);
        } catch (Exception ignored) {
            Throwable cause = chuckie.realCause(ignored);
            log.error(cause);
        }
    }
}
