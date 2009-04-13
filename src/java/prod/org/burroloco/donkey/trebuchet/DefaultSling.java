package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;

public class DefaultSling implements Sling {
    Impl impl;
    
    public void release(Specification spec) {
        Config config = spec.config();
        Loop loop = loop(spec);
        loop.go(config);
    }

    private Loop loop(Specification spec) {
        Class<? extends Loop> loopType = spec.loop();
        return impl.impl(loopType);
    }
}
