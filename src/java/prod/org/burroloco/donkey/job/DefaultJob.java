package org.burroloco.donkey.job;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.listener.core.ErrorEventListener;

public class DefaultJob implements Job {
    private final Job delegate;
    ErrorEventListener error;
    ThrowableMaster chuckie;

    public DefaultJob(Job delegate) {
        this.delegate = delegate;
    }

    public void go(Config config) {
        try {
            delegate.go(config);
        } catch (RuntimeException e) {
            error.onError(config);
            chuckie.rethrow(chuckie.rootCause(e));
        }
    }
}
