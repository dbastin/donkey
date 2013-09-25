package org.burroloco.donkey.demo.http2csv;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.gargle.NoOpTupleGargler;
import org.burroloco.donkey.gargle.TupleGargler;
import org.burroloco.donkey.job.ExceptionWrapper;
import org.burroloco.donkey.job.HttpListener;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.csv.CsvSpitter;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class HttpToCsvWirer implements Wirer {
    Wire wire;
    Dna dna;

    public void wire(Config config) {
        dna.strand(Job.class, ExceptionWrapper.class, HttpListener.class);
        wire.cls(NoOpTupleGargler.class).to(TupleGargler.class);
        wire.cls(CsvSpitter.class).to(Spitter.class);
    }
}
