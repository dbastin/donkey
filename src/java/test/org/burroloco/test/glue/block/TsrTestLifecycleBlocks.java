package org.burroloco.test.glue.block;

import au.net.netstorm.boost.gunge.array.ArrayMaster;
import au.net.netstorm.boost.gunge.array.DefaultArrayMaster;
import au.net.netstorm.boost.sniper.lifecycle.BoostTestLifecycleBlocks;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlocks;

public class TsrTestLifecycleBlocks implements TestLifecycleBlocks {
    TestLifecycleBlocks delegate = new BoostTestLifecycleBlocks();
    ArrayMaster arrays = new DefaultArrayMaster();

    public Class[] pre() {
        Class[] before = {BasedirBlock.class, OverrideConfigBlock.class, WireConfigBlock.class};
        Class[] boost = delegate.pre();
        Class[] after = {InsertDataBlock.class};
        return arrays.plus(arrays.plus(before, boost), after);
    }

    public Class[] post() {
        return delegate.post();
    }

    public Class[] cleanup() {
        Class[] boost = delegate.cleanup();
        return arrays.plus(boost, DeleteDataBlock.class);
    }
}
