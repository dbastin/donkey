package org.burroloco.donkey.demo.transform;

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
import org.burroloco.donkey.output.csv.CsvSpitter;
import org.burroloco.donkey.transform.Mapper;
import org.burroloco.donkey.transform.PropertyFileMapper;
import org.burroloco.donkey.transform.TupleGargler;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class TransformWirer implements Wirer {
    private static final String FULLNAME_MAPPINGS = "config/transform/fullname-mappings.properties";
     //SIMIAN OFF
    Wire wire;
    Dna dna;
    //SIMIAN ON

    public void wire(Config config) {
        slurp();
        transform();
        wire.cls(CsvSpitter.class).to(Spitter.class);
    }

    private void slurp() {
        dna.strand(Job.class, ExceptionWrapperJob.class, ConsumeTransformProduce.class);
        wire.cls(DatabaseSlurper.class).to(Slurper.class);
    }

    private void transform() {
        dna.strand(ExceptionHandler.class, LoggingExceptionHandler.class);
        wire.impl(PropertyFileMapper.class, FULLNAME_MAPPINGS).to(Mapper.class);
        wire.cls(FullNameTupleGargler.class).to(TupleGargler.class);
    }
}