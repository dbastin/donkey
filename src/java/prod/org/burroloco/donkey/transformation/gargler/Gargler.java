package org.burroloco.donkey.transformation.gargler;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Data;

public interface Gargler {
    Data gargle(Config config, Data in);
}