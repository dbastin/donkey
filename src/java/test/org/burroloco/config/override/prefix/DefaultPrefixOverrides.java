package org.burroloco.config.override.prefix;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;

import java.util.Map;

public class DefaultPrefixOverrides implements PrefixOverrides {
    Map<Class<? extends Strong>, String> prefixes;
    Impl impl;

    public void prefix(Class<? extends Strong> type, String prefix) {
        prefixes.put(type, prefix);
    }

    public Config apply(Config config) {
        Config result = config;
        for (Class<? extends Strong> type : prefixes.keySet()) result = prefix(result, type);
        return result;
    }

    private Config prefix(Config result, Class<? extends Strong> type) {
        String prefix = prefixes.get(type);
        return impl.impl(PrefixingConfig.class, result, type, prefix);
    }
}
