package org.burroloco.donkey.web;

import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.scope.Scoper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.runtime.Nu;

public class ExtraScoperWeb implements Web {
    Mapper mapper;
    Scoper scoper;
    Nu nu;

    public void web() {
        scoper.scope("org.burroloco");
        mapper.prefix("Default");
        ExtraScoper extraScoper = nu.nu(ExtraScoper.class);
        extraScoper.scope("src/java/test/org/burroloco/donkey/web/scope.properties");
    }
}
