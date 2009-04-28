package org.burroloco.donkey.glue.testcase;

import au.net.netstorm.boost.gunge.array.DefaultArrayMaster;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import org.burroloco.donkey.glue.web.DonkeyTestWeb;
import org.burroloco.donkey.web.DonkeyWeb;

public class DonkeyTestCase extends LifecycleTestCase implements InjectableTest {
    private static final Class[] WEBS = {
            DonkeyWeb.class,
            DonkeyTestWeb.class
    };

    public Class[] webs() {
        Class[] parents = super.webs();
        return new DefaultArrayMaster().plus(parents, WEBS);
    }
}
