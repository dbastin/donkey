package org.burroloco.donkey.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.trebuchet.Donkey;

public class FeedingDonkey implements Donkey {
    Taster taster;

    public void eat(Config config) {
        taster.sample(config);
    }
}