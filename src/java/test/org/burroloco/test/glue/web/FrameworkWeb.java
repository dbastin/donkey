package org.burroloco.test.glue.web;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.config.override.core.DefaultOverrides;
import org.burroloco.config.override.core.Overrides;

public class FrameworkWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(DefaultOverrides.class).one().to(Overrides.class);
    }
}
