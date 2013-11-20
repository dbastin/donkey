package org.burroloco.donkey.demo.jdbc2https;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.exception.gargle.GarglerExceptionHandler;
import org.burroloco.donkey.exception.gargle.LoggingGarglerExceptionHandler;
import org.burroloco.donkey.gargle.NoOpTupleGargler;
import org.burroloco.donkey.gargle.TupleGargler;
import org.burroloco.donkey.gargle.XmlTupleGargler;
import org.burroloco.donkey.job.ConsumeTransformProduce;
import org.burroloco.donkey.job.ExceptionWrapper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.recorder.DefaultTupleRecorder;
import org.burroloco.donkey.slurp.core.Slurper;
import org.burroloco.donkey.slurp.database.DatabaseSlurper;
import org.burroloco.donkey.spit.core.RecordingTupleSpitter;
import org.burroloco.donkey.spit.core.TupleSpitter;
import org.burroloco.donkey.spit.database.DatabaseTupleSpitter;
import org.burroloco.donkey.spit.http.HttpsTupleSpitter;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class JdbcToHttpsWirer implements Wirer {
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
        wire.cls(LoggingGarglerExceptionHandler.class).to(GarglerExceptionHandler.class);
    }

    private void slurper() {
        wire.cls(DatabaseSlurper.class).to(Slurper.class);
    }

    private void gargler() {
        wire.cls(XmlTupleGargler.class).to(TupleGargler.class);
    }

    private void spitter() {
        dna.strand(TupleSpitter.class, RecordingTupleSpitter.class, HttpsTupleSpitter.class);
        wire.cls(NoOpTupleGargler.class).to(TupleGargler.class, DefaultTupleRecorder.class);
        wire.cls(DatabaseTupleSpitter.class).to(TupleSpitter.class, DefaultTupleRecorder.class);
    }
}
