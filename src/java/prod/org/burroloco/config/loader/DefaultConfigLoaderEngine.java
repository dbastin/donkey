package org.burroloco.config.loader;

import org.burroloco.config.core.Config;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.gunge.collection.DefaultStrictMap;
import au.net.netstorm.boost.spider.api.runtime.Nu;

public class DefaultConfigLoaderEngine implements ConfigLoaderEngine {
    ConfigMapExpander expander;
    PropertiesLoader loader;
    Nu nu;

    public Config load(boolean override, String... filenames) {
        StrictMap<String, String> result = new DefaultStrictMap<String, String>();
        for (String filename : filenames) loadFile(result, filename, override);
        return nu.nu(Config.class, result);
    }

    private void loadFile(StrictMap<String, String> result, String filename, boolean override) {
        StrictMap<String, String> map = loader.load(filename);
        StrictMap<String, String> expanded = expander.expand(map);
        addAll(result, expanded, override);
    }

    private void addAll(StrictMap result, StrictMap expanded, boolean override) {
        for (Object key : expanded.keySet()) {
            if (override) result.remove(key);
            result.put(key, expanded.get(key));
        }
    }
}
