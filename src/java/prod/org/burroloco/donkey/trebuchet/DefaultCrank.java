package org.burroloco.donkey.trebuchet;

import org.burroloco.config.core.Config;

public class DefaultCrank implements Crank {
    ConfigWirer wirer;

    public void crank(Specification spec) {
        Config config = spec.config();
        Class<? extends Wirer> wirer = spec.wirer();
        this.wirer.wire(config, wirer);
    }
}
