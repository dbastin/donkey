package org.burroloco.config.core;

import au.net.netstorm.boost.gunge.goop.Nvp;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.runtime.Nu;

// FIX DONKEY Need to obey the natural order of things - if config is PrefixingConfig do not change it to DefaultConfig
public class DefaultConfigs implements Configs {
    Nu nu;

    public Config moosh(Config config, Nvp... entries) {
        StrictMap<String, String> map = config.map();
        for (Nvp entry : entries) {
            moosh(map, entry);
        }
        return nu.nu(Config.class, map);
    }

    private void moosh(StrictMap<String, String> map, Nvp entry) {
        String key = entry.name();
        if (map.exists(key)) map.remove(key);
        map.put(key, (String) entry.value());
    }
}
