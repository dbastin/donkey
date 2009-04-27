package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.HashMap;
import java.util.Map;

public class DefaultSlicer implements Slicer {
    Nu nu;

    public Map<String, String> stringMap(Slice slice) {
        Map<String, String> map = new HashMap<String, String>();
        for (String name : slice.names()) copy(map, slice, name);
        return map;
    }

    private void copy(Map<String, String> map, Slice slice, String name) {
        map.put(name, slice.value(name).toString());
    }
}
