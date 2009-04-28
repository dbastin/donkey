package org.burroloco.config.core;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;

public class DefaultParser implements Parser {
    Weaken weaken;
    Nu nu;

    public <T extends Strong> T parse(Class<T> type, String value) {
        Object warped = warp(type, value);
        return nu.nu(type, warped);
    }

    private Object warp(Class type, String value) {
        Class weak = weaken.w(type);
        if (weak == Long.class) return Long.parseLong(value);
        return value;
    }
}
