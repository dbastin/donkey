package org.burroloco.donkey.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.watcher.DirectoryWatcher;
import org.burroloco.donkey.input.watcher.DirectoryWatcherWirer;
import org.burroloco.donkey.trebuchet.Loop;

public class DirectoryWatcherLoop implements Loop {
    DirectoryWatcherWirer watchers;

    public void go(Config config) {
        DirectoryWatcher control = watchers.nu(config);
        control.start();
    }
}
