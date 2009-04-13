package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.runtime.Impl;

public class DefaultTestTrebuchet implements TestTrebuchet {
    Spinneret spinneret;
    Sling sling;
    Crank crank;
    Impl impl;

    public void launch(Class<? extends Specification> specCls, Class<? extends Web>... extras) {
        Specification spec = impl.impl(specCls);
        crank.crank(spec);
        spinneret.spin(extras);
        sling.release(spec);
    }
}
