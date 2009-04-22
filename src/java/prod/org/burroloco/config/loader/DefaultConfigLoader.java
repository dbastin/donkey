package org.burroloco.config.loader;

import org.burroloco.config.core.Config;

public class DefaultConfigLoader implements ConfigLoader {
    ConfigLoaderEngine engine;

    public Config load(String... filenames) {
        return engine.load(false, filenames);
    }

    public Config overload(String... filenames) {
        return engine.load(true, filenames);
    }

}
