package org.burroloco.butcher.glue.web;

import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.web.Web;

public class ButcherWeb implements Web {
    String scope = "org.burroloco";
    Mapper mapper;

    public void web() {
        mapper.prefix("Default", scope);
    }
}
