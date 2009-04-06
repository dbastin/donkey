package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.spider.api.runtime.Resolver;

public class DefaultDirWatcherStopper implements DirWatcherStopper {
    Resolver resolver;

    public void stop() {
        // try/catch is required for resolve, as failures can occur before the DirWatcher is even bound.
        try {
            resolver.resolve(DirWatcher.class).stop();
        } catch (Exception ignore) {}
    }
}
