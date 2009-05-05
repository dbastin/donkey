package org.burroloco.donkey.web;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.scope.Scoper;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.loader.DefaultPropertiesLoader;
import org.burroloco.config.loader.PropertiesLoader;

import java.util.Set;

public class DefaultExtraScoperEngine implements ExtraScoperEngine {
    Mapper mapper;
    Scoper scoper;
    Impl impl;

    public void scope(String extras) {
        StrictMap<String, String> scope = load(extras);
        Set<String> packageNames = scope.keySet();
        for (String name : packageNames) add(name, scope.get(name));
    }

    private StrictMap<String, String> load(String extras) {
        PropertiesLoader loader = impl.impl(DefaultPropertiesLoader.class);
        return loader.load(extras);
    }

    private void add(String pkg, String impls) {
        scoper.scope(pkg);
        pattern(impls);
    }

    private void pattern(String pattern) {
        String impl = pattern.replaceAll("\\*", "");
        if (pattern.startsWith("*")) mapper.suffix(impl);
        if (pattern.endsWith("*")) mapper.prefix(impl);
    }

}
