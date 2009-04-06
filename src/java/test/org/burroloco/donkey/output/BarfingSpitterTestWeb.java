package org.burroloco.donkey.output;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.donkey.output.core.Spitter;

public class BarfingSpitterTestWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(BarfingSpitter.class).to(Spitter.class);
    }
}
