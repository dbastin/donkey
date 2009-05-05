package au.com.scope.test.included;

import au.net.netstorm.boost.spider.api.runtime.Impl;

public class DefaultInScope implements InScope {
    Impl impl;

    public String externalize() {
        return impl.impl(String.class, "inScope");
    }
}
