package org.burroloco.donkey.web;

import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.factory.Factorer;
import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.plugs.factory.supplied.ThreadedFactory;
import org.burroloco.donkey.core.ConnectionCacheWeb;
import org.burroloco.donkey.core.LoggingWeb;
import org.burroloco.donkey.log.LogWeb;
import org.burroloco.donkey.output.core.SpitterWeb;
import org.burroloco.util.wire.UtilitiesWeb;

public class DonkeyWeb implements Web {
    String scope = "org.burroloco";
    Spinneret spinneret;
    Factorer factorer;
    Mapper mapper;

    public void web() {
        mapper.prefix("Default", scope);
        factorer.add(ThreadedFactory.class);
        spinneret.spin(LogWeb.class, LoggingWeb.class, ConnectionCacheWeb.class, SpitterWeb.class, UtilitiesWeb.class);
    }
}
