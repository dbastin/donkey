package org.burroloco.config.loader;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.io.FileInputStream;
import edge.java.io.InputStream;
import edge.java.util.Properties;

import java.util.Set;

public class DefaultPropertiesLoader implements PropertiesLoader {
    Nu nu;

    public StrictMap<String, String> load(String filename) {
        Properties properties = read(filename);
        return convert(properties);
    }

    private StrictMap<String, String> convert(Properties properties) {
        StrictMap<String, String> map = nu.nu(StrictMap.class);
        Set<String> keys = properties.keySet();
        for (String key : keys) {
            map.put(key, properties.getProperty(key));
        }
        return map;
    }

    private Properties read(String propertiesFilename) {
        InputStream is = nu.nu(FileInputStream.class, propertiesFilename);
        Properties properties = nu.nu(Properties.class);
        properties.load(is);
        is.close();
        return properties;
    }
}
