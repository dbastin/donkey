package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.List;
import java.util.Set;

public class StubSlice implements Slice, Constructable {
    private static final String DONT_CARE = "";
    private Slice delegate;
    Nu nu;

    public void constructor() {
        delegate = nu.nu(Slice.class);
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

    public void addAll(Slice slice) {
        delegate.addAll(slice);
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
