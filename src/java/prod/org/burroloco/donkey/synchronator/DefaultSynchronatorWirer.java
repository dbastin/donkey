package org.burroloco.donkey.synchronator;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.core.EmptyCheckSpitter;
import org.burroloco.donkey.output.core.ContextualSpitter;
import org.burroloco.donkey.output.csv.CsvSpitter;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.csv.CsvSlurper;
import org.burroloco.donkey.input.database.DatabaseSlurper;
import org.burroloco.util.wire.Dna;

public class DefaultSynchronatorWirer implements SynchronatorWirer {
    Impl impl;
    Wire wire;
    Dna dna;

    public void wire() {
        wire.cls(CsvSlurper.class).to(Slurper.class, DefaultArchive.class);
        wire.cls(DatabaseSlurper.class).to(Slurper.class, DefaultSynchronator.class);
        spitter();
    }

    private void spitter() {
        dna.strand(Spitter.class, EmptyCheckSpitter.class, CsvSpitter.class);
        contextualSpitter("insert", DefaultInsert.class);
        contextualSpitter("update", DefaultUpdate.class);
        contextualSpitter("delete", DefaultDelete.class);
    }

    private void contextualSpitter(String prefix, Class<? extends Operation> host) {
        Spitter spitter = impl.impl(ContextualSpitter.class, prefix);
        wire.ref(spitter).to(Spitter.class, host);
    }
}
