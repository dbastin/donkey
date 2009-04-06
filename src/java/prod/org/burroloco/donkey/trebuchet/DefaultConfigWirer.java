package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;

public class DefaultConfigWirer implements ConfigWirer {
    Impl impl;
    
    public void wire(Config config, Class<? extends Wirer> cls) {
        Wirer wirer = impl.impl(cls);
        wirer.wire(config);
    }
}
