package org.burroloco.donkey.input.watcher;

import org.burroloco.config.core.Config;

public interface DirectoryWatcher {
    void start(Config config);

    void stop();
}
