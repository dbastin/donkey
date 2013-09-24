package org.burroloco.donkey.demo.jdbc2http;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.transform.GarglerExceptionHandler;
import org.burroloco.donkey.error.transform.LoggingGarglerExceptionHandler;
import org.burroloco.donkey.slurp.core.Slurper;
import org.burroloco.donkey.slurp.database.DatabaseSlurper;
import org.burroloco.donkey.job.ConsumeTransformProduce;
import org.burroloco.donkey.job.ExceptionWrapper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.http.HttpSpitter;
import org.burroloco.donkey.gargle.NoOpTupleGargler;
import org.burroloco.donkey.gargle.TupleGargler;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class JdbcToHttpWirer implements Wirer {
    //SIMIAN OFF
    Wire wire;
    Dna dna;
    //SIMIAN ON

    public void wire(Config config) {
        job();
        consumer();
        transformer();
        producer();
    }

    private void job() {
        dna.strand(Job.class, ExceptionWrapper.class, ConsumeTransformProduce.class);
        dna.strand(GarglerExceptionHandler.class, LoggingGarglerExceptionHandler.class);
    }

    private void consumer() {
        wire.cls(DatabaseSlurper.class).to(Slurper.class);
    }

    private void transformer() {
        wire.cls(NoOpTupleGargler.class).to(TupleGargler.class);
    }

    private void producer() {
        wire.cls(HttpSpitter.class).to(Spitter.class);
    }
}
