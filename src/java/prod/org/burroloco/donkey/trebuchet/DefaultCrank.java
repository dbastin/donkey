package org.burroloco.donkey.trebuchet;

import org.burroloco.config.core.Config;

public class DefaultCrank implements Crank {
    ConfigWirer wirer;

    public void crank(Specification spec, Config config) {
        Class<? extends Wirer> cls = spec.wirer();
        wirer.wire(config, cls);
    }
}
