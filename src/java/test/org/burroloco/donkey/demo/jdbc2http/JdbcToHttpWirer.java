package org.burroloco.donkey.demo.jdbc2http;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.transform.ExceptionHandler;
import org.burroloco.donkey.error.transform.LoggingExceptionHandler;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.database.DatabaseSlurper;
import org.burroloco.donkey.job.ConsumeTransformProduce;
import org.burroloco.donkey.job.ExceptionWrapperJob;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.http.HttpSpitter;
import org.burroloco.donkey.transformation.transform.NoOpTupleTransformer;
import org.burroloco.donkey.transformation.transform.TupleTransformer;
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
        dna.strand(Job.class, ExceptionWrapperJob.class, ConsumeTransformProduce.class);
    }

    private void producer() {
        wire.cls(HttpSpitter.class).to(Spitter.class);
    }

    private void transformer() {
        dna.strand(ExceptionHandler.class, LoggingExceptionHandler.class);
        wire.cls(NoOpTupleTransformer.class).to(TupleTransformer.class);
    }

    private void consumer() {
        wire.cls(DatabaseSlurper.class).to(Slurper.class);
    }
}
