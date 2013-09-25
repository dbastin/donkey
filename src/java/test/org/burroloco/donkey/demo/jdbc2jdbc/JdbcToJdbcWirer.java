package org.burroloco.donkey.demo.jdbc2jdbc;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.gargle.NoOpTupleGargler;
import org.burroloco.donkey.gargle.TupleGargler;
import org.burroloco.donkey.job.ConsumeTransformProduce;
import org.burroloco.donkey.job.ExceptionWrapper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.slurp.core.ContextualSlurper;
import org.burroloco.donkey.slurp.core.Slurper;
import org.burroloco.donkey.slurp.database.DatabaseSlurper;
import org.burroloco.donkey.spit.core.ContextualSpitter;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.database.DatabaseSpitter;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class JdbcToJdbcWirer implements Wirer {
    //SIMIAN OFF
    Wire wire;
    Dna dna;
    //SIMIAN ON

    public void wire(Config config) {
        dna.strand(Job.class, ExceptionWrapper.class, ConsumeTransformProduce.class);
        slurper();
        gargler();
        spitter();
    }

    private void slurper() {
        wire.cls(DatabaseSlurper.class).to(Slurper.class, ContextualSlurper.class);
        wire.impl(ContextualSlurper.class, "input").to(Slurper.class);
    }

    private void gargler() {
        wire.cls(NoOpTupleGargler.class).to(TupleGargler.class);
    }

    private void spitter() {
        wire.cls(DatabaseSpitter.class).to(Spitter.class, ContextualSpitter.class);
        wire.impl(ContextualSpitter.class, "output").to(Spitter.class);
    }
}
