package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.spider.api.runtime.Nu;

public class DefaultSliceReplicator implements SliceReplicator {
    Nu nu;

    public Slice clone(Slice original, Slice changes) {
        Slice newSlice = nu.nu(Slice.class);
        for (String name : original.names()) {
            Slice source = source(original, changes, name);
            newSlice.add(name, source.value(name));
        }
        return newSlice;
    }

    private Slice source(Slice original, Slice changes, String name) {
        return find(changes, name) ? changes : original;
    }

    private boolean find(Slice changes, String key) {
        return changes.names().contains(key);
    }

}
