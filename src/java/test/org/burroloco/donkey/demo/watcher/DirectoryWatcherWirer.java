package org.burroloco.donkey.demo.watcher;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.exception.job.JobExceptionHandler;
import org.burroloco.donkey.exception.job.ShiftyJobExceptionHandler;
import org.burroloco.donkey.exception.job.SwallowingJobExceptionHandler;
import org.burroloco.donkey.gargle.NoOpTupleGargler;
import org.burroloco.donkey.gargle.TupleGargler;
import org.burroloco.donkey.job.ConsumeTransformProduce;
import org.burroloco.donkey.job.DirectoryWatcher;
import org.burroloco.donkey.job.ExceptionWrapper;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.Poller;
import org.burroloco.donkey.slurp.core.Slurper;
import org.burroloco.donkey.slurp.csv.CsvSlurper;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.file.DefaultOutputFileWizard;
import org.burroloco.donkey.spit.file.FileSpitter;
import org.burroloco.donkey.spit.file.FileWizard;
import org.burroloco.donkey.spit.file.ShiftySpitter;
import org.burroloco.donkey.spit.file.UniqueFileWizard;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class DirectoryWatcherWirer implements Wirer {
    Wire wire;
    Dna dna;

    public void wire(Config config) {
        dna.strand(JobExceptionHandler.class, ShiftyJobExceptionHandler.class, SwallowingJobExceptionHandler.class);
        dna.strand(Job.class, Poller.class, DirectoryWatcher.class, ExceptionWrapper.class, ConsumeTransformProduce.class);
        wire.cls(CsvSlurper.class).to(Slurper.class);
        wire.cls(NoOpTupleGargler.class).to(TupleGargler.class);
        spitter();
    }

    private void spitter() {
        wire.cls(UniqueFileWizard.class).to(FileWizard.class, DefaultOutputFileWizard.class);
        dna.strand(Spitter.class, ShiftySpitter.class, FileSpitter.class);
    }
}
