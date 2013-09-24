package org.burroloco.donkey.slurp.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;

public class ContextualSlurper implements Slurper {
    private final String propertyPrefix;
    Slurper delegate;

    public ContextualSlurper(String propertyPrefix) {
        this.propertyPrefix = propertyPrefix;
    }

    public Data slurp(Config config) {
        Config flattened = config.flatten(propertyPrefix);
        return delegate.slurp(flattened);
    }
}
