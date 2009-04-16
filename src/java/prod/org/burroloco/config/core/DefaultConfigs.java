package org.burroloco.config.core;

import au.net.netstorm.boost.gunge.goop.Nvp;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.runtime.Nu;

public class DefaultConfigs implements Configs {
    Nu nu;

    public Config moosh(Config config, Nvp... entries) {
        StrictMap<String, String> map = config.map();
        for (Nvp entry : entries) {
            add(map, entry);
        }
        return nu.nu(Config.class, map);
    }

    private void add(StrictMap<String, String> map, Nvp entry) {
        String key = entry.name();
        if (map.exists(key)) map.remove(key);
        map.put(key, (String) entry.value());
    }
}
