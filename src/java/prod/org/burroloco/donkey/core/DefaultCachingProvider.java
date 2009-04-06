package org.burroloco.donkey.core;

import au.net.netstorm.boost.spider.plugs.provider.core.DelegatingProvider;
import au.net.netstorm.boost.spider.plugs.provider.core.Provider;

import java.util.HashMap;
import java.util.Map;

public class DefaultCachingProvider extends DelegatingProvider implements CachingProvider {
    private final Map<String, Object> cache = new HashMap<String, Object>();

    public DefaultCachingProvider(Provider delegate) {
        super(delegate);
    }

    public Object nu(Object... args) {
        String key = key(args);
        Object o = cache.get(key);
        if (o == null) {
            o = delegate.nu(args);
            cache.put(key, o);
        }
        return o;
    }

    private String key(Object... args) {
        String key = "";
        for (Object arg : args) {
            key += arg;
        }
        return key;
    }

}