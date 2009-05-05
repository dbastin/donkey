package org.thirdparty.scope.test;

import au.net.netstorm.boost.spider.api.runtime.Impl;

public class DefaultFredString implements FredString {
    Impl impl;

    public String externalize() {
        return impl.impl(String.class, "fred");
    }
}
