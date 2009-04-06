package org.burroloco.config.wire;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import org.burroloco.config.core.Config;

public interface ConfigRegistrar {
    <T, U extends Strong<T>> void register(Config config, Class<U> cls);
}
