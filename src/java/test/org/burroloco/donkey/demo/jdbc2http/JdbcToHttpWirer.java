package org.burroloco.donkey.demo.jdbc2http;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.transform.ExceptionHandler;
import org.burroloco.donkey.error.transform.LoggingExceptionHandler;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.database.DatabaseSlurper;
import org.burroloco.donkey.job.ConsumeTransformProduce;
import org.burroloco.donkey.job.ExceptionWrapper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.http.HttpSpitter;
import org.burroloco.donkey.transform.NoOpTupleGargler;
import org.burroloco.donkey.transform.TupleGargler;
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
        dna.strand(ExceptionHandler.class, LoggingExceptionHandler.class);
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
