package org.burroloco.donkey.transform;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;

public interface DataGargler {
    Data gargle(Config config, Data in);
}