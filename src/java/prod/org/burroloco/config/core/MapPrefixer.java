package org.burroloco.config.core;

import au.net.netstorm.boost.gunge.collection.StrictMap;

public interface MapPrefixer {
    StrictMap<String, String> keys(StrictMap<String, String> map, String prefix);
}
