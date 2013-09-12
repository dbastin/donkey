package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.spider.api.config.web.Web;

public interface TestTrebuchet {
    void launch(Class<? extends Specification> specCls, Class<? extends Web>... overrides);
}
