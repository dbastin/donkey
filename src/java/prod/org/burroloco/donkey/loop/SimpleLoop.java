package org.burroloco.donkey.loop;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.job.Job;

// FIX TSR-DONKEY Delete loops...
public class SimpleLoop implements Loop {
    Nu nu;

    public void go(Config config) {
        Job job = nu.nu(Job.class);
        job.go(config);
    }
}
