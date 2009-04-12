package org.burroloco.donkey.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.watcher.DirWatcher;
import org.burroloco.donkey.input.watcher.DirWatcherWirer;
import org.burroloco.donkey.trebuchet.Loop;

public class ContinuousLoop implements Loop {
    DirWatcherWirer wirer;

    public void go(Config config) {
        DirWatcher control = wirer.nu(config);
        control.start();
    }
}
