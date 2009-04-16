package org.burroloco.donkey.loop;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.watcher.DirectoryWatcher;

public class DirectoryWatcherLoop implements Loop {
    DirectoryWatcher watcher;

    public void go(Config config) {
        watcher.start(config);
    }
}
