package org.burroloco.donkey.data.core;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.List;
import java.util.Set;

public class StubTuple implements Tuple, Constructable {
    private static final String DONT_CARE = "";
    private Tuple delegate;
    Nu nu;

    public void constructor() {
        delegate = nu.nu(Tuple.class);
    }

    public void add(String name, Object value) {
        delegate.add(name, value);
    }

    public Object value(String name) {
        return ignoreMissing(name);
    }

    public List<Object> values() {
        return delegate.values();
    }

    public Set<String> names() {
        return delegate.names();
    }

    public void readOnly() {
        delegate.readOnly();
    }

    public void addAll(Tuple tuple) {
        delegate.addAll(tuple);
    }

    public String toString() {
        return delegate.toString();
    }

    private Object ignoreMissing(String name) {
        try {
            return delegate.value(name);
        } catch (Exception e) {
            return DONT_CARE;
        }
    }
}
