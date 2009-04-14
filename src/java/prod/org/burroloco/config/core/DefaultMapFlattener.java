package org.burroloco.config.core;

import au.net.netstorm.boost.gunge.array.ArrayMaestro;
import au.net.netstorm.boost.gunge.collection.DefaultStrictMap;
import au.net.netstorm.boost.gunge.collection.StrictMap;

// FIX TSR-DONKEY Use or Lose
public class DefaultMapFlattener implements MapFlattener {
    private static final String DELIMITER = ".";
    ArrayMaestro arrays;

    public StrictMap<String, String> flatten(StrictMap<String, String> from, String label) {
        StrictMap<String, String> to = copy(from);
        flatten(label, to);
        return to;
    }

    private void flatten(String label, StrictMap<String, String> map) {
        String[] keys = arrays.array(map.keySet(), String.class);
        for (String key : keys) flatten(label, map, key);
    }

    private void flatten(String label, StrictMap<String, String> map, String key) {
        if (!key.startsWith(label + DELIMITER)) return;
        String flat = key.replace(label + DELIMITER, "");
        map.put(flat, map.get(key));
    }

    private StrictMap<String, String> copy(StrictMap<String, String> from) {
        StrictMap<String, String> copy = new DefaultStrictMap<String, String>();
        for (String key : from.keySet()) copy.put(key, from.get(key));
        return copy;
    }
}
