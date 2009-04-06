package org.burroloco.util.wire;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.util.string.DefaultStringUnique;
import org.burroloco.util.string.LongNameUnique;
import org.burroloco.util.string.ShortNameUnique;

public class UtilitiesWeb implements Web {
    Wire wire;

    public void web() {
        wire.impl(DefaultStringUnique.class, true, 3, 12).to(ShortNameUnique.class);
        wire.impl(DefaultStringUnique.class, false, 2, 32).to(LongNameUnique.class);
    }
}
