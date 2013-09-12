package org.burroloco.donkey.synchronator;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Data;

public interface Operation {
    void execute(Config c, String[] keys, Data older, Data newer);
    
}
