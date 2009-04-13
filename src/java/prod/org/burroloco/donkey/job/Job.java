package org.burroloco.donkey.job;

import org.burroloco.config.core.Config;

public interface Job {
    void go(Config config);
}
