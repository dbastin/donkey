package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;

public class DefaultTrebuchet implements Trebuchet {
    Sling sling;
    Crank crank;
    Impl impl;

    public void launch(Class<? extends Payload> type) {
        Payload payload = impl.impl(type);
        Config config = payload.config();
        crank.crank(payload, config);
        sling.release(payload, config);
    }
}
