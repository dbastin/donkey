package org.burroloco.donkey.demo.jdbc2http;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.gargle.GarglerExceptionHandler;
import org.burroloco.donkey.error.gargle.LoggingGarglerExceptionHandler;
import org.burroloco.donkey.gargle.DataGargler;
import org.burroloco.donkey.gargle.DefaultXmlGargler;
import org.burroloco.donkey.job.ConsumeTransformProduce;
import org.burroloco.donkey.job.ExceptionWrapper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.slurp.core.Slurper;
import org.burroloco.donkey.slurp.database.DatabaseSlurper;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.http.HttpSpitter;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class JdbcToHttpWirer implements Wirer {
    //SIMIAN OFF
    Wire wire;
    Dna dna;
    //SIMIAN ON

    public void wire(Config config) {
        job();
        slurper();
        gargler();
        spitter();
    }

    private void job() {
        dna.strand(Job.class, ExceptionWrapper.class, ConsumeTransformProduce.class);
        dna.strand(GarglerExceptionHandler.class, LoggingGarglerExceptionHandler.class);
    }

    private void slurper() {
        wire.cls(DatabaseSlurper.class).to(Slurper.class);
    }

    private void gargler() {
        wire.cls(DefaultXmlGargler.class).to(DataGargler.class);
    }

    private void spitter() {
        wire.cls(HttpSpitter.class).to(Spitter.class);
    }
}
