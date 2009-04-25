package org.burroloco.donkey.error.listener.core;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.config.core.Config;

public class DefaultErrorHandler implements ErrorHandler {
    ThrowableMaster chuckie;

    public void error(Config config, Exception exception) {
        Throwable cause = chuckie.rootCause(exception);
        chuckie.rethrow(cause);
    }
}
