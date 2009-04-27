package org.burroloco.donkey.error.listener.core;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.bullet.log.Log;
import org.burroloco.config.core.Config;

public class DefaultPuker implements Puker {
    ThrowableMaster chuckie;
    Log log;

    public void error(Config config, Exception exception) {
        Throwable cause = chuckie.realCause(exception);
        log.error(cause);
        chuckie.rethrow(cause);
    }
}
