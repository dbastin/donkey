package org.burroloco.demo.jdbc2jdbc;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.database.DatabaseSlurper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.SafeJob;
import org.burroloco.donkey.job.SlurpingJob;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.database.DatabaseSpitter;
import org.burroloco.donkey.transformation.transform.NoOpTransform;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class JdbcToJdbcWirer implements Wirer {
    Wire wire;
    Dna dna;

    //SIMIAN OFF
    public void wire(Config config) {
        dna.strand(Job.class, SafeJob.class, SlurpingJob.class);
        wire.cls(DatabaseSlurper.class).to(Slurper.class);
        wire.cls(NoOpTransform.class).to(Transform.class);
        wire.cls(DatabaseSpitter.class).to(Spitter.class);
    }
    //SIMIAN ON
}
