package org.burroloco.donkey.demo.csv2sql;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.gargle.NoOpTupleGargler;
import org.burroloco.donkey.gargle.TupleGargler;
import org.burroloco.donkey.job.ConsumeTransformProduce;
import org.burroloco.donkey.job.ExceptionWrapper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.slurp.core.Slurper;
import org.burroloco.donkey.slurp.csv.CsvSlurper;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.file.FileSpitter;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class CsvToSqlWirer implements Wirer {
    Wire wire;
    Dna dna;

    public void wire(Config config) {
        dna.strand(Job.class, ExceptionWrapper.class, ConsumeTransformProduce.class);
        wire.cls(CsvSlurper.class).to(Slurper.class);
        wire.cls(NoOpTupleGargler.class).to(TupleGargler.class);
        wire.cls(FileSpitter.class).to(Spitter.class);
    }
}
