package org.burroloco.util.csv;

import au.net.netstorm.boost.gunge.collection.StrictMap;

import java.util.ArrayList;
import java.util.List;

public class DefaultCommaSeparatedMapValues implements CommaSeparatedMapValues {
    CommaSeparatedValues separated;

    public List<String> list(StrictMap<String, String> map, String[] keys) {
        List<String> values = new ArrayList<String>();
        for (String key : keys) {
            values.addAll(list(map, key));
        }
        return values;
    }

    private List<String> list(StrictMap<String, String> map, String key) {
        return separated.list(map.get(key));
    }
}
