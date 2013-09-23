package org.burroloco.donkey.synchronator;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.DataMaster;
import org.burroloco.donkey.output.core.Spitter;

public class Delete implements Operation {
    DataMaster master;
    Spitter spitter;

    public void execute(Config c, String[] keys, Data older, Data newer) {
        Data deletes = master.minus(older, newer, keys);
        spitter.spit(c, deletes);
    }
}
