package org.burroloco.test.glue.block;

import au.net.netstorm.boost.gunge.array.ArrayMaster;
import au.net.netstorm.boost.gunge.array.DefaultArrayMaster;
import au.net.netstorm.boost.sniper.lifecycle.BoostTestLifecycleBlocks;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlocks;

public class DonkeyTestLifecycleBlocks implements TestLifecycleBlocks {
    TestLifecycleBlocks delegate = new BoostTestLifecycleBlocks();
    ArrayMaster arrays = new DefaultArrayMaster();

    public Class[] pre() {
        Class[] before = {BasedirBlock.class};
        Class[] boost = delegate.pre();
        return arrays.plus(before, boost);
    }

    public Class[] post() {
        return delegate.post();
    }

    public Class[] cleanup() {
        return delegate.cleanup();
    }
}
