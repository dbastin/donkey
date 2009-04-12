package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;

public class DefaultTestTrebuchet implements TestTrebuchet {
    Spinneret spinneret;
    Sling sling;
    Crank crank;
    Impl impl;

    public void launch(Class<? extends Job> type, Class<? extends Web>... extras) {
        Job job = impl.impl(type);
        Config config = job.config();
        crank.crank(job, config);
        spinneret.spin(extras);
        sling.release(job, config);
    }
}
