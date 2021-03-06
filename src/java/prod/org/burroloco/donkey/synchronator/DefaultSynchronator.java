package org.burroloco.donkey.synchronator;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.slurp.core.Slurper;

public class DefaultSynchronator implements Synchronator {
    private static final String BASE = "config/synchronator/";
    Operation operations;
    ConfigLoader loader;
    Archive archive;
    Slurper slurper;

    public void sync(Subject s) {
        String name = s.name();
        String[] keys = s.keys();
        Config config = config(name);
        Data older = archive.get(name);
        Data newer = slurper.slurp(config);
        operations.execute(config, keys, older, newer);
    }

    private Config config(String name) {
        return loader.overload(BASE + "synchronator.properties", BASE + name + ".properties");
    }
}
