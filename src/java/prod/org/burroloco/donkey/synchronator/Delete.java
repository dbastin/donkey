package org.burroloco.donkey.synchronator;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Patissier;
import org.burroloco.donkey.output.core.Spitter;

public class Delete implements Operation {
    Patissier patissier;
    Spitter spitter;

    public void execute(Config c, String[] keys, Cake older, Cake newer) {
        Cake deletes = patissier.minus(older, newer, keys);
        spitter.pertuh(c, deletes);
    }
}
