package org.burroloco.donkey.error;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.job.Job;

public class BarfingJob implements Job {
    public void go(Config config) {
        throw new RuntimeException("Something terrible happened to the job."); 
    }
}
