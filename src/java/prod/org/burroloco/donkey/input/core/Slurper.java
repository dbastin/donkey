package org.burroloco.donkey.input.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Data;

public interface Slurper {
    Data slurp(Config config);
}
