package org.burroloco.donkey.output.config;

import org.burroloco.config.core.Config;
import org.burroloco.config.core.MapFlattener;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.output.core.Spitter;

public class SqlContextSpitter implements Spitter {
    MapFlattener flattener;
    Spitter delegate;

    public void pertuh(Config config, Cake cake) {
        delegate.pertuh(config.flatten("sql"), cake);
    }
}