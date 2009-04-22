package org.burroloco.demo.jdbc2jdbc;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.core.ContextualSlurper;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.database.DatabaseSlurper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.SafeJob;
import org.burroloco.donkey.job.SlurpingJob;
import org.burroloco.donkey.output.core.ContextualSpitter;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.database.DatabaseSpitter;
import org.burroloco.donkey.transformation.transform.NoOpTransform;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class JdbcToJdbcWirer implements Wirer {
    //SIMIAN OFF
    Wire wire;
    Dna dna;
    //SIMIAN ON

    public void wire(Config config) {
        dna.strand(Job.class, SafeJob.class, SlurpingJob.class);
        slurper();
        gargler();
        spitter();
    }

    private void slurper() {
        wire.cls(DatabaseSlurper.class).to(Slurper.class, ContextualSlurper.class);
        wire.impl(ContextualSlurper.class, "input").to(Slurper.class);
    }

    private void gargler() {
        wire.cls(NoOpTransform.class).to(Transform.class);
    }

    private void spitter() {
        wire.cls(DatabaseSpitter.class).to(Spitter.class, ContextualSpitter.class);
        wire.impl(ContextualSpitter.class, "output").to(Spitter.class);
    }
}
