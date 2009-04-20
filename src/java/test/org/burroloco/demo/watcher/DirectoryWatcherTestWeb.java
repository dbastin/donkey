package org.burroloco.demo.watcher;

import au.net.netstorm.boost.gunge.lifecycle.Stop;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.donkey.input.watcher.AsyncJob;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.PollingJob;

public class DirectoryWatcherTestWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(AsyncJob.class).one().to(Job.class).to(Stop.class);
        wire.cls(PollingJob.class).to(Job.class, AsyncJob.class);
    }
}
