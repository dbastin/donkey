package org.burroloco.test.glue.block;

import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlock;
import org.burroloco.config.override.core.Overrides;
import org.burroloco.test.glue.marker.OverridesConfig;

public class OverrideConfigBlock implements TestLifecycleBlock {
    Overrides overrides;
    Marker marker;
    Test test;
    
    public void execute() {
        if (marker.is(test, OverridesConfig.class)) ((OverridesConfig) test).override(overrides);
    }
}
