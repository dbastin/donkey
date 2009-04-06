package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.spider.api.runtime.Impl;

public class DefaultSqlWrapper implements SqlWrapper {
    Impl impl;
    
    public String wrap(String sql, String wrap) {
        WrappingSqlBuilder wrapper = impl.impl(WrappingSqlBuilder.class, wrap);
        return wrapper.build(sql);
    }
}
