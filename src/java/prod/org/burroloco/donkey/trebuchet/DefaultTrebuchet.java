package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.runtime.Impl;

public class DefaultTrebuchet implements Trebuchet {
    Sling sling;
    Crank crank;
    Impl impl;

    public void launch(Class<? extends Specification> specCls) {
        Specification spec = impl.impl(specCls);
        crank.crank(spec);
        sling.release(spec);
    }
}
