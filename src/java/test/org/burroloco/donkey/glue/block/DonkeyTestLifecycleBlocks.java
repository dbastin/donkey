package org.burroloco.donkey.glue.block;

import au.net.netstorm.boost.sniper.lifecycle.BoostTestLifecycleBlocks;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlocks;

public class DonkeyTestLifecycleBlocks implements TestLifecycleBlocks {
    TestLifecycleBlocks delegate = new BoostTestLifecycleBlocks();

    public Class[] pre() {
        return delegate.pre();
    }

    public Class[] post() {
        return delegate.post();
    }

    public Class[] cleanup() {
        return delegate.cleanup();
    }
}
