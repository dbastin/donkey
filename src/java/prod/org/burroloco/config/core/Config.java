package org.burroloco.config.core;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;

public interface Config {   
    <T extends Strong> T get(Class<T> type);
    Config flatten(String label);
}
