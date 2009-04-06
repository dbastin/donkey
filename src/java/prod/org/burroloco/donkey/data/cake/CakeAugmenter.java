package org.burroloco.donkey.data.cake;

import org.burroloco.config.core.Config;
public interface CakeAugmenter {
    Cake augment(Config config, Cake cake, String key);
}
