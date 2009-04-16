package org.burroloco.config.core;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import au.net.netstorm.boost.gunge.collection.StrictMap;

public interface Config {   
    <T extends Strong> T get(Class<T> type);
    Config flatten(String label);

    StrictMap<String, String> map();
}
