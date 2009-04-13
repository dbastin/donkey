package org.burroloco.donkey.loop;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.core.Job;

public class SingleLoop implements Loop {
    Job job;

    public void go(Config config) {
        job.go(config);
    }
}