package org.burroloco.donkey.synchronator;

import au.net.netstorm.boost.bullet.hub.Hubs;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.donkey.slurp.core.Slurper;
import org.burroloco.donkey.slurp.database.DatabaseSlurper;
import org.burroloco.donkey.slurp.database.ResultSetValues;
import org.burroloco.donkey.slurp.database.StringResultSetValues;
import org.burroloco.donkey.spit.core.ContextualSpitter;
import org.burroloco.donkey.spit.core.EmptyCheckSpitter;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.file.FileSpitter;
import org.burroloco.donkey.spit.template.DefaultSqlTemplateExpander;
import org.burroloco.donkey.spit.template.DefaultTemplateExpander;
import org.burroloco.donkey.spit.template.TemplateExpander;
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
        dna.strand(TemplateExpander.class, DefaultSqlTemplateExpander.class, DefaultTemplateExpander.class);
        dna.strand(Spitter.class, EmptyCheckSpitter.class, FileSpitter.class);
        contextualSpitter("delete", Delete.class);
        contextualSpitter("update", Update.class);
        contextualSpitter("insert", Insert.class);
    }

    private void contextualSpitter(String prefix, Class<? extends Operation> host) {
        Spitter spitter = impl.impl(Spitter.class, ContextualSpitter.class, prefix);
        wire.ref(spitter).to(Spitter.class, host);
    }

    private void synchronator() {
        wire.cls(DatabaseSlurper.class).to(Slurper.class, DefaultSynchronator.class);
        wire.cls(StringResultSetValues.class).to(ResultSetValues.class);
        Operation operations = hubs.nu(Operation.class, Delete.class, Update.class, Insert.class);
        wire.ref(operations).to(Operation.class);
    }
}
