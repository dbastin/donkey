package org.burroloco.donkey.loop;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.job.Job;

public class SingleLoop implements Loop {
    Job job;

    public void go(Config config) {
        job.go(config);
    }
}