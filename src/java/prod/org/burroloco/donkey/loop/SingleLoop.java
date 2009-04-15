package org.burroloco.donkey.loop;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.SlurpingJob;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;

public class SingleLoop implements Loop {
    Impl impl;
    Nu nu;

    public void go(Config config) {
        Job slurping = impl.impl(SlurpingJob.class);
        Job job = nu.nu(Job.class, slurping);
        job.go(config);
    }
}