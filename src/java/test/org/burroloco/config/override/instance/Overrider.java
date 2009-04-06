package org.burroloco.config.override.instance;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import org.burroloco.config.core.Config;

public interface Overrider {
    Config override(Config config, Class<? extends Strong> type, Object instance);
}
