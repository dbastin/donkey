package org.burroloco.donkey.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.trebuchet.Loop;

public class OneLoop implements Loop {
    Job job;

    public void go(Config config) {
        job.go(config);
    }
}