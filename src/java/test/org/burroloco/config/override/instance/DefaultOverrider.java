package org.burroloco.config.override.instance;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;

public class DefaultOverrider implements Overrider {
    Impl impl;
    Nu nu;
    
    public Config override(Config config, Class<? extends Strong> type, Object instance) {
        Object strong = nu.nu(type, instance);
        return impl.impl(InstanceOverrideConfig.class, config, type, strong);
    }
}
