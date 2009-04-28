package org.burroloco.donkey.error;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.config.core.Config;

public class BulletProofPuker implements Puker {
    ThrowableMaster chuckie;
    Puker delegate;
    Log log;

    public void error(Config config, Exception e) {
        logCause(e);
        try {
            delegate.error(config, e);
        } catch (Exception ignored) {
            logCause(ignored);
        }
    }

    private void logCause(Exception e) {
        Throwable cause = chuckie.realCause(e);
        log.error(cause);
    }
}
