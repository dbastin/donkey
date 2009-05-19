package org.burroloco.donkey.synchronator;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;

public interface Operation {
    void execute(Config c, String[] keys, Cake older, Cake newer);
    
}
