package org.burroloco.test.glue.web;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.spider.plugs.provider.core.Provider;
import edge.org.dbunit.database.IDatabaseConnection;
import org.burroloco.donkey.cache.CachingProvider;
import org.burroloco.test.util.dbunit.IDatabaseConnectionProvider;

public class IConnectionCacheWeb implements Web {
    Impl impl;
    Wire wire;
    Nu nu;

    public void web() {
        Provider connectionProvider = nu.nu(CachingProvider.class, impl.impl(IDatabaseConnectionProvider.class));
        wire.provider(connectionProvider).to(IDatabaseConnection.class);
    }
}