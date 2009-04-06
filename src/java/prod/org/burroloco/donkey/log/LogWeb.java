package org.burroloco.donkey.log;

import au.net.netstorm.boost.bullet.log.LogEngine;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;

public class LogWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(Slf4jLogEngine.class).to(LogEngine.class);
    }
}
