package org.burroloco.donkey.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.watcher.DirWatcher;
import org.burroloco.donkey.input.watcher.DirWatcherWirer;
import org.burroloco.donkey.trebuchet.Donkey;

public class WatchingDonkey implements Donkey {
    DirWatcherWirer wirer;

    public void eat(Config config) {
        DirWatcher control = wirer.nu(config);
        control.start();
    }
}
