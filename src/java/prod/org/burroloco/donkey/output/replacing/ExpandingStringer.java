package org.burroloco.donkey.output.replacing;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;

public interface ExpandingStringer {
    String text(Config config, Cake cake);
}
