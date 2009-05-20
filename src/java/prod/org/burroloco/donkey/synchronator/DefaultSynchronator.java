package org.burroloco.donkey.synchronator;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.core.Slurper;

public class DefaultSynchronator implements Synchronator {
    Operation operations;
    Archive archive;
    Slurper slurper;

    public void sync(Subject s, Config c) {
        Cake older = archive.get(s.name());
        Cake newer = slurper.slurp(c);
        String[] keys = s.keys();
        operations.execute(c, keys, older, newer);
    }
}
