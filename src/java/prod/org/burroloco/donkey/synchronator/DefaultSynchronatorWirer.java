package org.burroloco.donkey.synchronator;

import au.net.netstorm.boost.bullet.hub.Hubs;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.database.DatabaseSlurper;
import org.burroloco.donkey.input.database.StringSliceValueHydrator;
import org.burroloco.donkey.input.database.SliceValueHydrator;
import org.burroloco.donkey.output.core.ContextualSpitter;
import org.burroloco.donkey.output.core.EmptyCheckSpitter;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.csv.CsvSpitter;
import org.burroloco.util.wire.Dna;

public class DefaultSynchronatorWirer implements SynchronatorWirer {
    Impl impl;
    Wire wire;
    Hubs hubs;
    Dna dna;

    public void wire() {
        spitter();
        synchronator();
    }

    private void spitter() {
        dna.strand(Spitter.class, EmptyCheckSpitter.class, CsvSpitter.class);
        contextualSpitter("delete", Delete.class);
        contextualSpitter("update", Update.class);
        contextualSpitter("insert", Insert.class);
    }

    private void contextualSpitter(String prefix, Class<? extends Operation> host) {
        Spitter spitter = impl.impl(ContextualSpitter.class, prefix);
        wire.ref(spitter).to(Spitter.class, host);
    }

    private void synchronator() {
        wire.cls(DatabaseSlurper.class).to(Slurper.class, DefaultSynchronator.class);
        wire.cls(StringSliceValueHydrator.class).to(SliceValueHydrator.class);
        Operation operations = hubs.nu(Operation.class, Delete.class, Update.class, Insert.class);
        wire.ref(operations).to(Operation.class);
    }
}
