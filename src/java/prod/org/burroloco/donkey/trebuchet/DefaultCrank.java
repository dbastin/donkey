package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;

public class DefaultCrank implements Crank {
    Impl impl;

    public void crank(Specification spec, Config config) {
        Class<? extends Wirer> wirerCls = spec.wirer();
        Wirer wirer = impl.impl(wirerCls);
        wirer.wire(config);
    }
}
