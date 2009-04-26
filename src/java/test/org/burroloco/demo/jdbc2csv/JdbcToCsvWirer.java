package org.burroloco.demo.jdbc2csv;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.database.DatabaseSlurper;
import org.burroloco.donkey.job.ErrorHandlingJob;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.SlurpingJob;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.csv.CsvSpitter;
import org.burroloco.donkey.transformation.error.LoggingTransformErrorHandler;
import org.burroloco.donkey.transformation.error.SwallowingTransformErrorHandler;
import org.burroloco.donkey.transformation.error.TransformErrorHandler;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class JdbcToCsvWirer implements Wirer {
    Wire wire;
    Dna dna;

    //SIMIAN OFF
    public void wire(Config config) {
        dna.strand(Job.class, ErrorHandlingJob.class, SlurpingJob.class);
        wire.cls(DatabaseSlurper.class).to(Slurper.class);
        dna.strand(TransformErrorHandler.class, LoggingTransformErrorHandler.class, SwallowingTransformErrorHandler.class);
        wire.cls(EmployeeTransform.class).to(Transform.class);
        wire.cls(CsvSpitter.class).to(Spitter.class);
    }
    //SIMIAN ON
}
