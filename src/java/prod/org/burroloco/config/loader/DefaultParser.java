package org.burroloco.config.loader;

import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.lang.ClassStatic;

public class DefaultParser implements Parser {
    ClassStatic classes;
    Weaken weaken;
    Nu nu;

    public <T extends Strong> T parse(Class<T> type, String value) {
        Object warped = warp(type, value);
        return nu.nu(type, warped);
    }

    private Object warp(Class type, String value) {
        Class weak = weaken.w(type);
        if (weak == Integer.class) return Integer.parseInt(value);
        if (weak == Long.class) return Long.parseLong(value);
        if (weak == Class.class) return classes.forName(value); 
        return value;
    }
}
