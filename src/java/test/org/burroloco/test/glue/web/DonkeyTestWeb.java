package org.burroloco.test.glue.web;

import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.web.Web;

public class DonkeyTestWeb implements Web {
    Spinneret spinneret;

    public void web() {
        spinneret.spin(SniperOverridesWeb.class, IConnectionCacheWeb.class, FrameworkWeb.class);
    }
}
