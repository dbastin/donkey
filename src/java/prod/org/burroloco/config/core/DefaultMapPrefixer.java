package org.burroloco.config.core;

import au.net.netstorm.boost.gunge.collection.DefaultStrictMap;
import au.net.netstorm.boost.gunge.collection.StrictMap;

import java.util.Set;

public class DefaultMapPrefixer implements MapPrefixer {

    public StrictMap<String, String> keys(StrictMap<String, String> map, String prefix) {
        StrictMap<String, String> result = new DefaultStrictMap<String, String>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String value = map.get(key);
            result.put(prefix + "." + key, value);
        }
        return result;
    }
}
