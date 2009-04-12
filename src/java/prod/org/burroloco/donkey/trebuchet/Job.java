package org.burroloco.donkey.trebuchet;

import org.burroloco.config.core.Config;

public interface Job {
    Config config();
    Class<? extends Wirer> wirer();
    Class<? extends Loop> loop();
}
