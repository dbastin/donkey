package org.burroloco.config.override.prefix;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import org.burroloco.config.override.core.ApplyOverrides;

public interface PrefixOverrides extends ApplyOverrides {
    void prefix(Class<? extends Strong> type, String prefix);
}
