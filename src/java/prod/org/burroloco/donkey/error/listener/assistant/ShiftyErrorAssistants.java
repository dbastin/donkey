package org.burroloco.donkey.error.listener.assistant;

import au.net.netstorm.boost.spider.api.runtime.Impl;

public class ShiftyErrorAssistants implements ErrorAssistants {
    Impl impl;

    public ErrorAssistant[] get() {
        ErrorAssistant fileShifter = impl.impl(ShiftyErrorAssistant.class);
        return new ErrorAssistant[]{fileShifter};
    }
}
