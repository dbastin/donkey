package org.burroloco.donkey.trebuchet;

import org.burroloco.config.core.Config;

public class DefaultCrank implements Crank {
    ConfigWirer wirer;

    public void crank(Job job, Config config) {
        Class<? extends Wirer> cls = job.wirer();
        wirer.wire(config, cls);
    }
}
