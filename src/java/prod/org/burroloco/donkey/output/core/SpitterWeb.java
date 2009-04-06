package org.burroloco.donkey.output.core;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.burroloco.donkey.output.config.SqlContextSpitter;
import org.burroloco.donkey.output.ice.SqlIcerSpitter;
import org.burroloco.donkey.output.replacing.ReplacingSpitter;

public class SpitterWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(SqlIcerSpitter.class).to(Spitter.class, SqlContextSpitter.class);
        wire.cls(ReplacingSpitter.class).to(Spitter.class, SqlIcerSpitter.class);
    }
}
