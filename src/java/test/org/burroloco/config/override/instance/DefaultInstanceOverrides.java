package org.burroloco.config.override.instance;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import org.burroloco.config.core.Config;

import java.util.Map;

public class DefaultInstanceOverrides implements InstanceOverrides {
    Map<Class<? extends Strong>, Object> instances;
    Overrider overrider;

    public void instance(Class<? extends Strong> type, Object instance) {
        instances.put(type, instance);
    }

    public Config apply(Config config) {
        Config result = config;
        for (Class<? extends Strong> type : instances.keySet()) result = instance(type, result);
        return result;
    }

    private Config instance(Class<? extends Strong> type, Config config) {
        Object instance = instances.get(type);
        return overrider.override(config, type, instance);
    }
}
