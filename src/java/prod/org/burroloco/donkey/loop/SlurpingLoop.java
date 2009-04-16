package org.burroloco.donkey.loop;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.job.SafeJob;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.SlurpingJob;

public class SlurpingLoop implements Loop {
    Wire wire;
    Nu nu;

    // FIX TSR-DONKEY This is not good. Wiring then impl? Hmmmm.
    public void go(Config config) {
        wire.cls(SafeJob.class).to(Job.class);
        wire.cls(SlurpingJob.class).to(Job.class, SafeJob.class);
        Job job = nu.nu(Job.class);
        job.go(config);
    }
}