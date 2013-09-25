package org.burroloco.donkey.demo.jdbc2csv;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.gargle.GarglerExceptionHandler;
import org.burroloco.donkey.error.gargle.LoggingGarglerExceptionHandler;
import org.burroloco.donkey.gargle.TupleGargler;
import org.burroloco.donkey.job.ConsumeTransformProduce;
import org.burroloco.donkey.job.ExceptionWrapper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.slurp.core.Slurper;
import org.burroloco.donkey.slurp.database.DatabaseSlurper;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.csv.CsvSpitter;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class JdbcToCsvWirer implements Wirer {
    //SIMIAN OFF
    Wire wire;
    Dna dna;
    //SIMIAN ON

    public void wire(Config config) {
        dna.strand(Job.class, ExceptionWrapper.class, ConsumeTransformProduce.class);
        wire.cls(DatabaseSlurper.class).to(Slurper.class);
        transformer();
        wire.cls(CsvSpitter.class).to(Spitter.class);
    }

    private void transformer() {
        dna.strand(GarglerExceptionHandler.class, LoggingGarglerExceptionHandler.class);
        wire.cls(EmployeeTupleGargler.class).to(TupleGargler.class);
    }
}
