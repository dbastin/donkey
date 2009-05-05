package org.burroloco.donkey.web;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.scope.Scoper;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.loader.DefaultPropertiesLoader;
import org.burroloco.config.loader.PropertiesLoader;

import java.io.File;
import java.util.Set;

public class DefaultExtraScoper implements ExtraScoper {
    Mapper mapper;
    Scoper scoper;
    Impl impl;
    Log log;

    public void scope(String fileName) {
        if (!hasExtras(fileName)) log(fileName);
        else addExtras(fileName);
    }

    private void addExtras(String extras) {
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

    private boolean hasExtras(String extras) {
        return new File(extras).exists();
    }

    private void log(String fileName) {
        log.info("No file: " + fileName + " containing extra injection scopes was found.");
    }
}
