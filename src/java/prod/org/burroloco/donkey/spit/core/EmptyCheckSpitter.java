package org.burroloco.donkey.spit.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;

import java.util.List;

public class EmptyCheckSpitter implements Spitter {
    Spitter delegate;

    public void spit(Config config, Data data) {
        if (!empty(data)) delegate.spit(config, data);
    }

    private boolean empty(Data data) {
        List<Tuple> tuples = data.tuples();
        return tuples.size() == 0;
    }
}
