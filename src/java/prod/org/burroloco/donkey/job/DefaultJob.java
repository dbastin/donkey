package org.burroloco.donkey.job;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.listener.core.ErrorEventListener;

// FIX TSR-DONKEY Rename to SafeJob.
public class DefaultJob implements Job {
    ErrorEventListener error;
    ThrowableMaster chuckie;
    Job delegate;

    public void go(Config config) {
        try {
            delegate.go(config);
        } catch (RuntimeException e) {
            error.onError(config);
            chuckie.rethrow(chuckie.rootCause(e));
        }
    }
}
