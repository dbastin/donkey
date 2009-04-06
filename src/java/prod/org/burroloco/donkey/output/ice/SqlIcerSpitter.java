package org.burroloco.donkey.output.ice;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.output.core.Spitter;

public class SqlIcerSpitter implements Spitter {
    Spitter delegate;
    SqlIcer icer;

    public void pertuh(Config config, Cake cake) {
        Cake iced = icer.transform(cake);
        delegate.pertuh(config, iced);
    }
}
