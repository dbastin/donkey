package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.HashMap;
import java.util.Map;

// FIX TSR-DONKEY Use or Lose
public class DefaultSlicer implements Slicer {
    Nu nu;

    public Slice copy(Slice slice) {
        Slice newSlice = nu.nu(Slice.class);
        newSlice.addAll(slice);
        return newSlice;
    }

    public Map<String, String> stringMap(Slice slice) {
        Map<String, String> map = new HashMap<String, String>();
        for (String name : slice.names()) copy(map, slice, name);
        return map;
    }

    private void copy(Map<String, String> map, Slice slice, String name) {
        map.put(name, slice.value(name).toString());
    }
}
