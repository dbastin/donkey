package org.burroloco.demo.tibco2fixed;

import au.net.netstorm.boost.gunge.lifecycle.Stop;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.donkey.input.watcher.AsyncJob;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.TibcoListenerJob;

public class TibcoToFixedWidthTestWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(AsyncJob.class).one().to(Job.class).to(Stop.class);
        wire.cls(TibcoListenerJob.class).to(Job.class, AsyncJob.class);
    }
}
