package org.burroloco.donkey.synchronator;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Patissier;
import org.burroloco.donkey.output.core.Spitter;

public class Update implements Operation {
    Patissier pattisier;
    Spitter spitter;

    public void execute(Config c, String[] keys, Data older, Data newer) {
        Data updates = pattisier.changes(newer, older, keys);
        spitter.spit(c, updates);
    }
}
