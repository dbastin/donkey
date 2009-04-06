package org.burroloco.donkey.transformation.gargler;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;

public interface Gargler {
    Cake slosh(Config config, Cake in);
}