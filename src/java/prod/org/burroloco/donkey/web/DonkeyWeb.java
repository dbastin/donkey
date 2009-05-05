package org.burroloco.donkey.web;

import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.factory.Factorer;
import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.scope.Scoper;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.plugs.factory.supplied.ThreadedFactory;
import org.burroloco.donkey.cache.ConnectionCacheWeb;
import org.burroloco.donkey.log.LoggingWeb;

public class DonkeyWeb implements Web {
    private static final String EXTRAS = "config/scope.properties";
    Spinneret spinneret;
    Factorer factorer;
    Mapper mapper;
    Scoper scoper;
    Impl impl;

    public void web() {
        scope();
        factorer.add(ThreadedFactory.class);
        spinneret.spin(LoggingWeb.class, ConnectionCacheWeb.class);
    }

    private void scope() {
        defaultScope();
        extraScope();
    }

    private void defaultScope() {
        scoper.scope("org.burroloco");
        mapper.prefix("Default");
    }

    private void extraScope() {
        ExtraScoper scoper = impl.impl(DefaultExtraScoper.class);
        scoper.scope(EXTRAS);
    }
}