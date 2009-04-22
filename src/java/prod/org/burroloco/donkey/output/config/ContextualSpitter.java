package org.burroloco.donkey.output.config;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.output.core.Spitter;

public class ContextualSpitter implements Spitter {
    private final String propertyPrefix;
    Spitter delegate;

    public ContextualSpitter(String propertyPrefix) {
        this.propertyPrefix = propertyPrefix;
    }

    public void pertuh(Config config, Cake cake) {
        Config flattened = config.flatten(propertyPrefix);
        delegate.pertuh(flattened, cake);
    }
}