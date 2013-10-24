package org.burroloco.donkey.scope.excluded;

import au.net.netstorm.boost.spider.api.runtime.Impl;

public class DefaultOutOfScope implements OutOfScope {
    Impl impl;

    public String externalize() {
        return impl.impl(String.class, "outOfScope");
    }
}
