package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.gunge.lifecycle.Stop;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.lang.Thread;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.job.Job;

public class AsyncJob implements Job, Stop {
    private Thread thread;
    Job delegate;
    Impl impl;
    Nu nu;

    public void go(final Config config) {
        Runnable r = new Runnable() {
            public void run() {
                delegate.go(config);
            }
        };
        thread = nu.nu(Thread.class, r);
        thread.start();
    }

    public void stop() {
        ((Stop) delegate).stop();
        thread.join();
    }
}
