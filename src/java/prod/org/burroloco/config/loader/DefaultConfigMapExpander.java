package org.burroloco.config.loader;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.commons.io.FileUtilsStatic;

import java.io.File;

public class DefaultConfigMapExpander implements ConfigMapExpander {
    private static final String PROPERTIES_PROTOCOL = "properties://";
    // FIX TSR-DONKEY Use, lose, or cover.
    private static final String CONTENTS_PROTOCOL = "contents://";
    FileUtilsStatic fileUtils;
    PropertiesLoader loader;
    Nu nu;

    public StrictMap<String, String> expand(StrictMap<String, String> map) {
        StrictMap<String, String> result = nu.nu(StrictMap.class);
        for (String key : map.keySet()) {
            String value = map.get(key);
            expandValue(result, key, value);
        }
        return result;
    }

    private void expandValue(StrictMap<String, String> result, String key, String value) {
        if (value.startsWith(CONTENTS_PROTOCOL)) {
            expandContents(result, key, value);
        } else if (value.startsWith(PROPERTIES_PROTOCOL)) {
            expandProperties(result, key, value);
        } else {
            result.put(key, value);
        }
    }

    private void expandProperties(StrictMap<String, String> result, String key, String value) {
        StrictMap<String, String> extraProps = loader.load(filename(PROPERTIES_PROTOCOL, value));
        putAll(result, key, extraProps);
    }

    private void expandContents(StrictMap<String, String> result, String key, String value) {
        File file = new File(filename(CONTENTS_PROTOCOL, value));
        String newValue = fileUtils.readFileToString(file);
        result.put(key, newValue);
    }

    private String filename(String prefix, String value) {
        return value.substring(prefix.length());
    }

    private void putAll(StrictMap<String, String> map, String origKey, StrictMap<String, String> extra) {
        for (String key : extra.keySet()) {
            replace(map, origKey + "." + key, extra.get(key));
        }
    }

    private void replace(StrictMap<String, String> map, String key, Object contents) {
        map.remove(key);
        map.put(key, (String) contents);
    }

}
