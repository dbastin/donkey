package org.burroloco.config.loader;

import au.net.netstorm.boost.gunge.collection.StrictMap;

public interface PropertiesLoader {
    StrictMap<String, String> load(String filename);
}
