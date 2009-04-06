package org.burroloco.config.core;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import au.net.netstorm.boost.bullet.incredibles.core.Weaken;

public class DefaultWeakConfig implements WeakConfig {
    Weaken weaken;

    public <T, U extends Strong<T>> T get(Config config, Class<U> type) {
        U strong = config.get(type);
        return weaken.w(strong);
    }
}
