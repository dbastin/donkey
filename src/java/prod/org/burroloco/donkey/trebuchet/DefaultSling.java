package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;

public class DefaultSling implements Sling {
    Impl impl;
    
    public void release(Job job, Config config) {
        Class<? extends Loop> loopType = job.looping();
        Loop loop = impl.impl(loopType);
        loop.go(config);
    }
}
