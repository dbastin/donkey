package org.burroloco.donkey.demo.watcher;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.job.Puker;
import org.burroloco.donkey.error.job.ShiftyPuker;
import org.burroloco.donkey.error.job.SwallowingPuker;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.csv.CsvSlurper;
import org.burroloco.donkey.job.DirectoryJob;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.PollingJob;
import org.burroloco.donkey.job.PukingJob;
import org.burroloco.donkey.job.SlurpingJob;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.file.DefaultOutputFileWizard;
import org.burroloco.donkey.output.file.FileSpitter;
import org.burroloco.donkey.output.file.FileWizard;
import org.burroloco.donkey.output.file.ShiftySpitter;
import org.burroloco.donkey.output.file.UniqueFileWizard;
import org.burroloco.donkey.transformation.transform.NoOpTransform;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class DirectoryWatcherWirer implements Wirer {
    Wire wire;
    Dna dna;

    public void wire(Config config) {
        dna.strand(Puker.class, ShiftyPuker.class, SwallowingPuker.class);
        dna.strand(Job.class, PollingJob.class, DirectoryJob.class, PukingJob.class, SlurpingJob.class);
        wire.cls(CsvSlurper.class).to(Slurper.class);
        wire.cls(NoOpTransform.class).to(Transform.class);
        spitter();
    }

    private void spitter() {
        wire.cls(UniqueFileWizard.class).to(FileWizard.class, DefaultOutputFileWizard.class);
        dna.strand(Spitter.class, ShiftySpitter.class, FileSpitter.class);
    }
}
