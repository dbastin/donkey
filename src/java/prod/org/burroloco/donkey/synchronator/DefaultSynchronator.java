package org.burroloco.donkey.synchronator;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.core.Slurper;

public class DefaultSynchronator implements Synchronator, Constructable {
    private Config config;
    Operation operations;
    ConfigLoader loader;
    Archive archive;
    Slurper slurper;

    public void constructor() {
        config = loader.load("config/synchronator/synchronator.properties");
    }

    public void sync(Subject s) {
        Cake older = archive.get(s.name());
        Cake newer = slurper.slurp(config);
        String[] keys = s.keys();
        operations.execute(config, keys, older, newer);
    }
}
