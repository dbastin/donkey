package org.burroloco.donkey.glue.web;

import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.web.Web;

public class DonkeyTestWeb implements Web {
    Spinneret spinneret;

    public void web() {
        // FIX TSR-DONKEY Inline these instead...
        spinneret.spin(SniperOverridesWeb.class, IConnectionCacheWeb.class);
    }
}
