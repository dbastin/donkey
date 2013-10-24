package org.burroloco.donkey.cache;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.spider.plugs.provider.core.Provider;
import edge.java.sql.Connection;
import org.burroloco.donkey.slurp.database.DatabaseConnectionProvider;

public class ConnectionCacheWeb implements Web {
    Wire wire;
    Impl impl;
    Nu nu;

    public void web() {
        Provider p = impl.impl(Provider.class, DatabaseConnectionProvider.class);
        CachingProvider provider = nu.nu(CachingProvider.class, p);
        wire.provider(provider).to(Connection.class);
    }
}