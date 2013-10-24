package org.burroloco.donkey.demo.transform;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.exception.gargle.GarglerExceptionHandler;
import org.burroloco.donkey.exception.gargle.LoggingGarglerExceptionHandler;
import org.burroloco.donkey.gargle.Mapper;
import org.burroloco.donkey.gargle.PropertyFileMapper;
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

public class TransformWirer implements Wirer {
    private static final String FULLNAME_MAPPINGS = "config/gargle/fullname-mappings.properties";
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
        dna.strand(Job.class, ExceptionWrapper.class, ConsumeTransformProduce.class);
        wire.cls(DatabaseSlurper.class).to(Slurper.class);
    }

    private void transform() {
        dna.strand(GarglerExceptionHandler.class, LoggingGarglerExceptionHandler.class);
        wire.impl(Mapper.class, PropertyFileMapper.class, FULLNAME_MAPPINGS).to(Mapper.class);
        wire.cls(FullNameTupleGargler.class).to(TupleGargler.class);
    }
}