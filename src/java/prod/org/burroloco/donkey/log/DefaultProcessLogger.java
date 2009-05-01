package org.burroloco.donkey.log;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;

public class DefaultProcessLogger implements ProcessLogger {
    ThrowableMaster chuckie;
    Log log;

    public void logStarted() {
        log.info("Process started");
    }

    public void logFinished() {
        log.info("Process completed successfully");
    }

    public void logError(RuntimeException e) {
        Throwable cause = chuckie.realCause(e);
        log.error("Process internal error: ", cause);
        log.info("Process terminated with an error");
    }

}
