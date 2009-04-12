package org.burroloco.donkey.trebuchet;

import org.burroloco.config.core.Config;

public interface Payload {
    Config config();
    Class<? extends Wirer> wirer();
    Class<? extends Loop> loop();
}
