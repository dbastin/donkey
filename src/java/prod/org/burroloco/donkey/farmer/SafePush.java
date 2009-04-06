package org.burroloco.donkey.farmer;

import au.net.netstorm.boost.bullet.farmer.Push;
import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.donkey.error.core.HandledException;

public class SafePush implements Push {
    ThrowableMaster chuckie;
    Push push;
    Log log;

    public void starting() {
        throw new UnsupportedOperationException();
    }

    public void push(Object o) {
        try {
            push.push(o);
        } catch (HandledException e) {
            ignore();
        } catch (Exception e) {
            log(e);
        }
    }

    private void log(Exception e) {
        log.info("Terminated with an error", chuckie.rootCause(e));
    }

    public void fail(Throwable t) {
        throw new UnsupportedOperationException();
    }

    private void ignore() {
    }

}
