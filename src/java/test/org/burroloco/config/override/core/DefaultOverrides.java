package org.burroloco.config.override.core;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import org.burroloco.config.core.Config;
import org.burroloco.config.override.instance.InstanceOverrides;
import org.burroloco.config.override.prefix.PrefixOverrides;

public class DefaultOverrides implements Overrides {
    InstanceOverrides instances;
    PrefixOverrides prefixes;

    public void instance(Class<? extends Strong> type, Object instance) {
        instances.instance(type, instance);
    }

    public void prefix(Class<? extends Strong> type, String prefix) {
        prefixes.prefix(type, prefix);
    }

    public Config apply(Config config) {
        Config result = config;
        result = instances.apply(result);
        result = prefixes.apply(result);
        return result;
    }
}
