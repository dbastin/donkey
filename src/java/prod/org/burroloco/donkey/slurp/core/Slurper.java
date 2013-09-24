package org.burroloco.donkey.slurp.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;

public interface Slurper {
    Data slurp(Config config);
}
