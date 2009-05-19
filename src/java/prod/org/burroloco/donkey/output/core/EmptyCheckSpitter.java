package org.burroloco.donkey.output.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;

import java.util.List;

public class EmptyCheckSpitter implements Spitter {
    Spitter delegate;

    public void pertuh(Config config, Cake cake) {
        if (!empty(cake)) delegate.pertuh(config, cake);
    }

    private boolean empty(Cake cake) {
        List<Slice> slices = cake.slices();
        return slices.size() == 0;
    }
}
