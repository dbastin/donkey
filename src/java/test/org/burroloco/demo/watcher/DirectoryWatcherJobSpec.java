package org.burroloco.demo.watcher;

import org.burroloco.donkey.trebuchet.JobSpec;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.donkey.trebuchet.Loop;
import org.burroloco.donkey.core.DirectoryWatcherLoop;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;

public class DirectoryWatcherJobSpec implements JobSpec {
    ConfigLoader loader;

    public Config config() {
        return loader.load("config/watcher.properties");
    }

    public Class<? extends Wirer> wirer() {
        return DirectoryWatcherWirer.class;
    }

    public Class<? extends Loop> loop() {
        return DirectoryWatcherLoop.class;
    }
}
