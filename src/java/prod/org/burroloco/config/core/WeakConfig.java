package org.burroloco.config.core;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;

public interface WeakConfig {
    <T, U extends Strong<T>> T get(Config config, Class<U> type);
}
