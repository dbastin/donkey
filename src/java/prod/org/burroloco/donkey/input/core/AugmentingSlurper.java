package org.burroloco.donkey.input.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.CakeAugmenter;

public class AugmentingSlurper implements Slurper {
    CakeAugmenter augmenter;
    Slurper slurper;

    public Cake slurp(Config config) {
        Config kplus = config.flatten("kplus");
        Cake cake = slurper.slurp(kplus);
        return augmenter.augment(config, cake, "DownloadKey");
    }
}
