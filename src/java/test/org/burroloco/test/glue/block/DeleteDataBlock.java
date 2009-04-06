package org.burroloco.test.glue.block;

import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlock;
import au.net.netstorm.boost.spider.api.runtime.Resolver;
import org.burroloco.interfaces.common.harness.Harness;
import org.burroloco.test.glue.marker.UsesHarness;

public class DeleteDataBlock implements TestLifecycleBlock {
    Resolver resolver;
    Marker marker;
    Test test;

    public void execute() {
        if (marker.is(test, UsesHarness.class)) delete();
    }

    private void delete() {
        Harness harness = resolver.resolve(Harness.class);
        harness.delete();
    }
}