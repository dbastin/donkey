package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.lang.Thread;
import org.burroloco.config.core.Config;

public class AsyncDirectoryWatcher implements DirectoryWatcher {
    private Thread thread;
    DirectoryWatcher delegate;
    Impl impl;
    Nu nu;

    public void start(final Config config) {
        Runnable r = new Runnable() {
            public void run() {
                delegate.start(config);
            }
        };
        thread = nu.nu(Thread.class, r);
        thread.start();
    }

    public void stop() {
        delegate.stop();
        thread.join();
    }
}
