package org.burroloco.donkey.trebuchet;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.loop.Loop;

public interface Specification {
    Config config();
    Class<? extends Wirer> wirer();
    Class<? extends Loop> loop();
}
