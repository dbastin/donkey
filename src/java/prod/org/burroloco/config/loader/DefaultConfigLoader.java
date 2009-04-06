package org.burroloco.config.loader;

import au.net.netstorm.boost.gunge.collection.DefaultStrictMap;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;

public class DefaultConfigLoader implements ConfigLoader {
    ConfigMapExpander expander;
    PropertiesLoader loader;
    Nu nu;

    public Config load(String... filenames) {
        StrictMap<String, String> result = new DefaultStrictMap<String, String>();
        for (String filename : filenames) loadFile(result, filename);
        return nu.nu(Config.class, result);
    }

    private void loadFile(StrictMap<String, String> result, String filename) {
        StrictMap<String, String> map = loader.load(filename);
        StrictMap<String, String> expanded = expander.expand(map);
        for (String key : expanded.keySet()) result.put(key, expanded.get(key));
    }
}
