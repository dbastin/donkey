package org.burroloco.donkey.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.trebuchet.Loop;

public class OneLoop implements Loop {
    Taster taster;

    public void go(Config config) {
        taster.sample(config);
    }
}