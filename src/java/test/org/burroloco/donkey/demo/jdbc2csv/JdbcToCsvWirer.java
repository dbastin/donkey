package org.burroloco.donkey.demo.jdbc2csv;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.transform.ErrorHandler;
import org.burroloco.donkey.error.transform.LoggingErrorHandler;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.database.DatabaseSlurper;
import org.burroloco.donkey.job.ConsumeTransformProduce;
import org.burroloco.donkey.job.ExceptionWrapperJob;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.csv.CsvSpitter;
import org.burroloco.donkey.transformation.transform.TupleTransformer;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class JdbcToCsvWirer implements Wirer {
    //SIMIAN OFF
    Wire wire;
    Dna dna;
    //SIMIAN ON

    public void wire(Config config) {
        dna.strand(Job.class, ExceptionWrapperJob.class, ConsumeTransformProduce.class);
        wire.cls(DatabaseSlurper.class).to(Slurper.class);
        transformer();
        wire.cls(CsvSpitter.class).to(Spitter.class);
    }

    private void transformer() {
        dna.strand(ErrorHandler.class, LoggingErrorHandler.class);
        wire.cls(EmployeeTupleTransformer.class).to(TupleTransformer.class);
    }
}
