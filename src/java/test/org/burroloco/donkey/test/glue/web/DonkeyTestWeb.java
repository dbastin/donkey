package org.burroloco.donkey.test.glue.web;

import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlocks;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.spider.plugs.provider.core.Provider;
import edge.org.dbunit.database.IDatabaseConnection;
import org.burroloco.butcher.util.dbunit.IDatabaseConnectionProvider;
import org.burroloco.donkey.cache.CachingProvider;
import org.burroloco.donkey.test.glue.block.DonkeyTestLifecycleBlocks;

public class DonkeyTestWeb implements Web {
    Impl impl;
    Wire wire;
    Nu nu;

    public void web() {
        wire.cls(DonkeyTestLifecycleBlocks.class).to(TestLifecycleBlocks.class);
        connections();
    }

    private void connections() {
        IDatabaseConnectionProvider reals = impl.impl(IDatabaseConnectionProvider.class);
        Provider cached = nu.nu(CachingProvider.class, reals);
        wire.provider(cached).to(IDatabaseConnection.class);
    }
}
