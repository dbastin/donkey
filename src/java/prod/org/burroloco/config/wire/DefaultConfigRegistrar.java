package org.burroloco.config.wire;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;

public class DefaultConfigRegistrar implements ConfigRegistrar {
    Wire wire;
    
    public <T, U extends Strong<T>> void register(Config config, Class<U> cls) {
        U value = config.get(cls);
        wire.ref(value).to(cls);
    }
}
