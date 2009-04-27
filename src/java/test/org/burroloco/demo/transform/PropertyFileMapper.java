package org.burroloco.demo.transform;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import org.burroloco.config.loader.PropertiesLoader;
import org.burroloco.donkey.transformation.transform.Mapper;

public class PropertyFileMapper implements Mapper, Constructable {
    private StrictMap<String, String> map;
    private String propertyFile;
    PropertiesLoader loader;

    public PropertyFileMapper(String propertyFile) {
        this.propertyFile = propertyFile;
    }

    public String map(String field) {
        return map.get(field);
    }

    public void constructor() {
        map = loader.load(propertyFile);
    }
}