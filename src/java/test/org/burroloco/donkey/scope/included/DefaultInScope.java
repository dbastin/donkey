package org.burroloco.donkey.scope.included;

import au.net.netstorm.boost.spider.api.runtime.Impl;

public class DefaultInScope implements InScope {
    Impl impl;

    public String externalize() {
        return impl.impl(String.class, String.class, "inScope");
    }
}
