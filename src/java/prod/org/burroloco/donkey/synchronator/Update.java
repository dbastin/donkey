package org.burroloco.donkey.synchronator;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.DataMaster;
import org.burroloco.donkey.spit.core.Spitter;

public class Update implements Operation {
    DataMaster pattisier;
    Spitter spitter;

    public void execute(Config c, String[] keys, Data older, Data newer) {
        Data updates = pattisier.diffs(newer, older, keys);
        spitter.spit(c, updates);
    }
}
