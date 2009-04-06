package org.burroloco.donkey.output;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.output.core.Spitter;

public class BarfingSpitter implements Spitter {
    RuntimeException e;
    public void pertuh(Config config, Cake cake) {
        throw e;
    }
}
