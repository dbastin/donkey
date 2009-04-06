package org.burroloco.donkey.trebuchet;

import org.burroloco.config.core.Config;

public class DefaultCrank implements Crank {
    ConfigWirer wirer;

    public void crank(Payload payload, Config config) {
        Class<? extends Wirer> cls = payload.wirer();
        wirer.wire(config, cls);
    }
}
