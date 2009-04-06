package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import static org.burroloco.test.constants.TestConstants.DONT_CARE;

public class DefaultTolerantBaker implements TolerantBaker {
    SliceReplicator cloner;
    Nu nu;

    public Cake clone(Cake in, String... ignoreMe) {
        Cake out = nu.nu(Cake.class);
        Slice ignores = nu.nu(Slice.class);
        for (String ignore : ignoreMe) ignores.add(ignore, DONT_CARE);
        for (Slice slice : in.slices()) out.add(cloner.clone(slice, ignores));
        out.refrigerate();
        return out;
    }
}
