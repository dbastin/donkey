package org.burroloco.config.override.instance;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import org.burroloco.config.core.Config;

public class InstanceOverrideConfig implements Config {
    private Config delegate;
    private Object value;
    private Class override;
    Impl impl;

    public InstanceOverrideConfig(Config delegate, Class override, Object value) {
        this.delegate = delegate;
        this.override = override;
        this.value = value;
    }

    public <T extends Strong> T get(Class<T> key) {
        if (key == override) return key.cast(value);
        return delegate.get(key);
    }

    public Config flatten(String label) {
        Config flat = delegate.flatten(label);
        return impl.impl(InstanceOverrideConfig.class, flat, override, value);
    }

    public StrictMap<String, String> map() {
        return delegate.map();
    }


}
