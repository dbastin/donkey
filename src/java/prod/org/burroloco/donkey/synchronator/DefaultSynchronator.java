package org.burroloco.donkey.synchronator;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.input.core.Slurper;

public class DefaultSynchronator implements Synchronator {
    Slurper slurper;
    Archive archive;
    Delete delete;
    Update update;
    Insert insert;

    public void sync(Subject s, Config c) {
        Cake older = archive.get(s.name());
        Cake newer = slurper.slurp(c);
        String[] keys = s.keys();
        delete.execute(c, keys, older, newer);
        update.execute(c, keys, older, newer);
        insert.execute(c, keys, older, newer);
    }
}
