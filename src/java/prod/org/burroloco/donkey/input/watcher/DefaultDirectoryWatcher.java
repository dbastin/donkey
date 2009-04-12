package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.gunge.lifecycle.StartStop;

public class DefaultDirectoryWatcher implements DirectoryWatcher {
    StartStop control;

    public void start() {
        control.start();
    }

    public void stop() {
        control.stop();
    }
}
