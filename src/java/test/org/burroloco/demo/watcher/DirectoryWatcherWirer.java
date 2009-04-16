package org.burroloco.demo.watcher;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.input.core.Slurper;
import org.burroloco.donkey.input.csv.CsvSlurper;
import org.burroloco.donkey.job.SafeJob;
import org.burroloco.donkey.job.DirectoryWatcherJob;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.PollingJob;
import org.burroloco.donkey.job.SlurpingJob;
import org.burroloco.donkey.output.core.Spitter;
import org.burroloco.donkey.output.file.ShiftySpitter;
import org.burroloco.donkey.output.replacing.FileSpitter;
import org.burroloco.donkey.transformation.transform.PassThroughTransform;
import org.burroloco.donkey.transformation.transform.Transform;
import org.burroloco.donkey.trebuchet.Wirer;

public class DirectoryWatcherWirer implements Wirer {
    Wire wire;

    public void wire(Config config) {
        poller();
        job();
    }

    // FIX TSR-DONKEY Does DNA do this instead?
    private void poller() {
        wire.cls(PollingJob.class).one().to(Job.class);
        wire.cls(DirectoryWatcherJob.class).to(Job.class, PollingJob.class);
        wire.cls(SafeJob.class).to(Job.class, DirectoryWatcherJob.class);
        wire.cls(SlurpingJob.class).to(Job.class, SafeJob.class);
    }

    //SIMIAN OFF
    private void job() {
        wire.cls(CsvSlurper.class).to(Slurper.class);
        wire.cls(PassThroughTransform.class).to(Transform.class);
        wire.cls(ShiftySpitter.class).to(Spitter.class);
        wire.cls(FileSpitter.class).to(Spitter.class, ShiftySpitter.class);
    }
    //SIMIAN ON
}
