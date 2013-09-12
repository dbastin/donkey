package org.burroloco.donkey.output.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;

public interface Spitter {
    void spit(Config config, Data data);
}
