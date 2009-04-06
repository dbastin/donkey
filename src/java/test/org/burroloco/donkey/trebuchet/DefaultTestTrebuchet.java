package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;

public class DefaultTestTrebuchet implements TestTrebuchet {
    Spinneret spinneret;
    Sling sling;
    Crank crank;
    Impl impl;

    public void launch(Class<? extends Payload> type, Class<? extends Web>... extras) {
        Payload payload = impl.impl(type);
        Config config = payload.config();
        crank.crank(payload, config);
        spinneret.spin(extras);
        sling.release(payload, config);
    }
}
