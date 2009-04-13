package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.lang.Thread;

public class AsyncDirectoryWatcher implements DirectoryWatcher {
    private Thread thread;
    DirectoryWatcher delegate;
    Impl impl;
    Nu nu;

    public void start() {
        StartRunnable r = impl.impl(StartRunnable.class, delegate);
        thread = nu.nu(Thread.class, r);
        thread.start();
    }

    public void stop() {
        delegate.stop();
        thread.join();
    }
}