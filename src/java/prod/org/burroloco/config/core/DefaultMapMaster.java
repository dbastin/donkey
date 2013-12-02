package org.burroloco.config.core;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.Set;

public class DefaultMapMaster<K, V> implements MapMaster<K, V> {
    Nu nu;

    public StrictMap<K, V> clone (StrictMap<K, V> map) {
         Set<K> keys = map.keySet();
         StrictMap<K, V> result = nu.nu(StrictMap.class);
         for (K key : keys) result.put(key, map.get(key));
         return result;
     }
}
