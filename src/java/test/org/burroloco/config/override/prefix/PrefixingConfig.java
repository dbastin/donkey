package org.burroloco.config.override.prefix;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import au.net.netstorm.boost.bullet.incredibles.core.Typen;
import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import org.burroloco.config.core.Config;

public class PrefixingConfig implements Config {
    private Config delegate;
    private String prefix;
    private Class override;
    Weaken weaken;
    Typen typen;
    Impl impl;
    Nu nu;

    public PrefixingConfig(Config delegate, Class override, String prefix) {
        this.delegate = delegate;
        this.prefix = prefix;
        this.override = override;
    }

    public <T extends Strong> T get(Class<T> type) {
        return type == override ? override(type) : delegate.get(type);
    }

    public Config flatten(String label) {
        Config flat = delegate.flatten(label);
        return impl.impl(PrefixingConfig.class, flat, override, prefix);
    }

    public StrictMap<String, String> map() {
        return delegate.map();
    }

    private <T extends Strong> T override(Class<T> type) {
        Strong<T> strong = delegate.get(type);
        Class stype = typen.t(strong);
        return (T) nu.nu(stype, prefix + get(strong));
    }

    private String get(Strong strong) {
        Object weak = weaken.w(strong);
        if (!(weak instanceof String)) throw new IllegalArgumentException("Invalid prefix type, expected String.");
        return (String) weak;
    }
}
