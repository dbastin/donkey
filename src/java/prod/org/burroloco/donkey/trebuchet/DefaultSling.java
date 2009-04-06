package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;

public class DefaultSling implements Sling {
    Impl impl;
    
    public void release(Payload payload, Config config) {
        Class<? extends Donkey> type = payload.donkey();
        Donkey donkey = impl.impl(type);
        donkey.eat(config);
    }
}
