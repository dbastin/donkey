package org.burroloco.test.glue.web;

import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlocks;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.test.glue.block.DonkeyTestLifecycleBlocks;

public class SniperOverridesWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(DonkeyTestLifecycleBlocks.class).to(TestLifecycleBlocks.class);
    }
}
