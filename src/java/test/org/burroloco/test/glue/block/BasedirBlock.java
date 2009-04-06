package org.burroloco.test.glue.block;

import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlock;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.spider.api.runtime.Resolver;
import org.burroloco.test.constants.TestConstants;
import org.burroloco.test.glue.marker.DistBasedir;
import org.burroloco.test.glue.type.Basedir;

public class BasedirBlock implements TestLifecycleBlock, TestConstants {
    Resolver resolver;
    Marker marker;
    Test test;
    Wire wire;
    Nu nu;

    public void execute() {
        if (marker.is(test, DistBasedir.class)) basedir(DIST_BASE_PATH);
        else basedir(TEST_BASE_PATH);
    }

    private void basedir(String basedir) {
        wire.nu(Basedir.class, basedir).to(Basedir.class);
    }

}