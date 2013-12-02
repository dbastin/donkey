package org.burroloco.config.core;

import au.net.netstorm.boost.gunge.collection.StrictMap;

public interface MapMaster<K, V> {
    StrictMap<K, V> clone(StrictMap<K, V> map);
}
