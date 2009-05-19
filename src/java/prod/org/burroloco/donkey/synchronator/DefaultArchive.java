package org.burroloco.donkey.synchronator;

import au.net.netstorm.boost.gunge.collection.DefaultStrictMap;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.core.Slurper;

public class DefaultArchive implements Archive {
    Slurper slurper;
    Nu nu;

    public Cake get(String name) {
        String location = toLocation(name);
        Config config = config(location);
        return slurper.slurp(config);
    }

    private String toLocation(String name) {
        return "data/archive/" + name + ".csv";
    }

    private Config config(String location) {
        StrictMap map = new DefaultStrictMap();
        map.put(InputFileName.NAME, location);
        return nu.nu(Config.class, map);
    }
}
