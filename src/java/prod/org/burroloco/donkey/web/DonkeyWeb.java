package org.burroloco.donkey.web;

import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.factory.Factorer;
import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.scope.Scoper;
import au.net.netstorm.boost.spider.plugs.factory.supplied.ThreadedFactory;
import org.burroloco.donkey.cache.ConnectionCacheWeb;
import org.burroloco.donkey.log.LoggingWeb;

public class DonkeyWeb implements Web {
    Spinneret spinneret;
    Factorer factorer;
    Mapper mapper;
    Scoper scoper;

    public void web() {
        scoper.scope("org.burroloco");
        mapper.prefix("Default");
        factorer.add(ThreadedFactory.class);
        spinneret.spin(LoggingWeb.class, ConnectionCacheWeb.class);
    }
}
