package org.burroloco.config.override.instance;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import org.burroloco.config.override.core.ApplyOverrides;

public interface InstanceOverrides extends ApplyOverrides {
    void instance(Class<? extends Strong> type, Object instance);
}
