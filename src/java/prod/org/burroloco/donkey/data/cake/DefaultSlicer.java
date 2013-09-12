package org.burroloco.donkey.data.cake;

import java.util.HashMap;
import java.util.Map;

public class DefaultSlicer implements Slicer {

    public Map<String, String> stringMap(Tuple tuple) {
        Map<String, String> map = new HashMap<String, String>();
        for (String name : tuple.names()) copy(map, tuple, name);
        return map;
    }

    private void copy(Map<String, String> map, Tuple tuple, String name) {
        map.put(name, tuple.value(name).toString());
    }
}
