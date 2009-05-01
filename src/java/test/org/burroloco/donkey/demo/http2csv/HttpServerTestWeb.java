package org.burroloco.donkey.demo.http2csv;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.HttpListenerJob;
import org.burroloco.donkey.input.watcher.AsyncJob;

public class HttpServerTestWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(AsyncJob.class).one().to(Job.class);
        wire.cls(HttpListenerJob.class).to(Job.class, AsyncJob.class);
    }
}
