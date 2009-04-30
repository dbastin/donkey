package org.burroloco.donkey.error.job;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;

public class DefaultPukerLogger implements PukerLogger {
    ThrowableMaster chuckie;
    Log log;

    public void log(RuntimeException e) {
        Throwable cause = chuckie.realCause(e);
        log.error("Job internal error: ", cause);
        log.info("Job terminated with an error");
    }
}
