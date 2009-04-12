package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;

public class DefaultTrebuchet implements Trebuchet {
    Sling sling;
    Crank crank;
    Impl impl;

    public void launch(Class<? extends Job> type) {
        Job job = impl.impl(type);
        Config config = job.config();
        crank.crank(job, config);
        sling.release(job, config);
    }
}
