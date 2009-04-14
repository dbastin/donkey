package org.burroloco.config.core;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.loader.Parser;

public class DefaultConfig implements Config {
    private StrictMap<String, String> map;
    ConfigClassMapper mapper;
    MapFlattener flattener;
    Parser parser;
    Nu nu;

    public DefaultConfig(StrictMap<String, String> map) {
        this.map = map;
    }

    public <T extends Strong> T get(Class<T> type) {
        String key = mapper.map(type);
        String orig = map.get(key);
        return parser.parse(type, orig);
    }

    // FIX TSR-DONKEY Use or Lose
    public Config flatten(String label) {
        StrictMap<String, String> flat = flattener.flatten(map, label);
        return nu.nu(Config.class, flat);
    }
}
