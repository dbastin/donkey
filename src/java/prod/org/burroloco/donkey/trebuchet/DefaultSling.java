package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.job.Job;

public class DefaultSling implements Sling {
    Nu nu;

    public void release(Config config) {
        Job job = nu.nu(Job.class);
        job.go(config);
    }
}
