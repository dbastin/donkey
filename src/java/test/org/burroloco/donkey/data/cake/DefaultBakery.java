package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.spider.api.runtime.Nu;

public class DefaultBakery implements Bakery {
    Nu nu;

    public Cake cake(int start, int end, String flavour) {
        Cake cake = nu.nu(Cake.class);
        for (int i = start; i <= end; i++)
            cake.add(bake(i, flavour));
        return cake;
    }

    private Slice bake(int key, String flavour) {
        Slice slice = nu.nu(Slice.class);
        slice.add("key", key);
        slice.add("flavour", flavour);
        slice.add("mainly", "flour");
        slice.add("some.Ref", "egg");
        return slice;
    }
}
