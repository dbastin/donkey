package org.burroloco.donkey.demo.watcher;

import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.trebuchet.Specification;
import org.burroloco.donkey.trebuchet.Wirer;

public class DirectoryWatcherSpecification implements Specification {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/watcher/watcher.properties");
    }

    public Class<? extends Wirer> wirer() {
        return DirectoryWatcherWirer.class;
    }
}
