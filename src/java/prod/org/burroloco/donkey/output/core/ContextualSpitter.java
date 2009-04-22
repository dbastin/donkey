package org.burroloco.donkey.output.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;

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