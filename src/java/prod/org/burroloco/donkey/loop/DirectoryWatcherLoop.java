package org.burroloco.donkey.loop;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.watcher.DirectoryWatcher;
import org.burroloco.donkey.input.watcher.DirectoryWatcherWirer;

public class DirectoryWatcherLoop implements Loop {
    DirectoryWatcherWirer watchers;

    public void go(Config config) {
        DirectoryWatcher watcher = watchers.nu(config);
        watcher.start();
    }
}
