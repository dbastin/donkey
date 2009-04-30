package org.burroloco.donkey.demo.http2jdbc;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.job.HttpListenerJob;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.job.PukingJob;
import org.burroloco.donkey.job.SlurpingJob;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.util.wire.Dna;

public class HttpToJdbcWirer implements Wirer {
    Wire wire;
    Dna dna;

    public void wire(Config config) {
        dna.strand(Job.class, HttpListenerJob.class, PukingJob.class, SlurpingJob.class);
    }
}
