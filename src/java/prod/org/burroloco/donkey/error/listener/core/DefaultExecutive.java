package org.burroloco.donkey.error.listener.core;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.listener.assistant.ErrorAssistant;

public class DefaultExecutive implements Executive {
    ThrowableMaster chuckie;
    Log log;

    public void ignore(Config config, ErrorAssistant assistant) {
        try {
            assistant.help(config);
        } catch (Exception ignored) {
            logAndSwallow(ignored);
        }
    }

    private void logAndSwallow(Exception e) {
        Throwable cause = chuckie.realCause(e);
        log.error(cause);
    }
}
