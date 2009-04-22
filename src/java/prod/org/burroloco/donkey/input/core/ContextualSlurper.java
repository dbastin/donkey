package org.burroloco.donkey.input.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;

public class ContextualSlurper implements Slurper {
    private final String propertyPrefix;
    Slurper delegate;

    public ContextualSlurper(String propertyPrefix) {
        this.propertyPrefix = propertyPrefix;
    }

    public Cake slurp(Config config) {
        Config flattened = config.flatten(propertyPrefix);
        return delegate.slurp(flattened);
    }
}
