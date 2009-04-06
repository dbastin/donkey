package org.burroloco.config.core;

import au.net.netstorm.boost.gunge.collection.StrictMap;

public interface MapFlattener {
    StrictMap<String, String> flatten(StrictMap<String, String> map, String label);
}
