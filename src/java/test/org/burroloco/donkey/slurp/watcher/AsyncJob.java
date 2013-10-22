package org.burroloco.donkey.slurp.watcher;

import au.net.netstorm.boost.gunge.lifecycle.Stop;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.lang.Thread;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.job.Job;

public class AsyncJob implements Job, Stop {
    private Thread thread;
    Job delegate;
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
