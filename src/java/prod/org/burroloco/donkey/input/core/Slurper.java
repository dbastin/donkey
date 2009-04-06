package org.burroloco.donkey.input.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;

public interface Slurper {
    Cake slurp(Config config);
}
