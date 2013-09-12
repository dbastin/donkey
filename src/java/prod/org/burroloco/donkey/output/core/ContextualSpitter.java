package org.burroloco.donkey.output.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;

public class ContextualSpitter implements Spitter {
    private final String propertyPrefix;
    Spitter delegate;

    public ContextualSpitter(String propertyPrefix) {
        this.propertyPrefix = propertyPrefix;
    }

    public void spit(Config config, Data data) {
        Config flattened = config.flatten(propertyPrefix);
        delegate.spit(flattened, data);
    }
}