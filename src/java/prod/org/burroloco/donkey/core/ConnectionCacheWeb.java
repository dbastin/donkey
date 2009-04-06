package org.burroloco.donkey.core;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.sql.Connection;
import org.burroloco.donkey.input.database.DatabaseConnectionProvider;

public class ConnectionCacheWeb implements Web {
    Wire wire;
    Impl impl;
    Nu nu;

    public void web() {
        CachingProvider provider = nu.nu(CachingProvider.class, impl.impl(DatabaseConnectionProvider.class));
        wire.provider(provider).to(Connection.class);
    }
}