package org.burroloco.butcher.glue.testcase;

import au.net.netstorm.boost.gunge.array.DefaultArrayMaster;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import org.burroloco.butcher.glue.web.ButcherWeb;

public class ButcherTestCase extends LifecycleTestCase implements InjectableTest {
    private static final Class[] WEBS = {
            ButcherWeb.class,
    };

    public Class[] webs() {
        Class[] parents = super.webs();
        return new DefaultArrayMaster().plus(parents, WEBS);
    }
}
