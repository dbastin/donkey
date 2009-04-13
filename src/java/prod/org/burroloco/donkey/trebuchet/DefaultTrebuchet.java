package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;

public class DefaultTrebuchet implements Trebuchet {
    Sling sling;
    Crank crank;
    Impl impl;

    public void launch(Class<? extends Specification> specCls) {
        Specification spec = impl.impl(specCls);
        Config config = spec.config();
        crank.crank(spec, config);
        sling.release(spec, config);
    }
}
