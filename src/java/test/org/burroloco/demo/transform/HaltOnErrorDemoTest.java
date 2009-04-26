package org.burroloco.demo.transform;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Bakery;
import org.burroloco.donkey.data.error.InconsistentSliceException;
import org.burroloco.donkey.transformation.gargler.Gargler;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class HaltOnErrorDemoTest extends DonkeyTestCase implements HasFixtures {
    private Gargler gargler;
    private Config noConfig;
    private Cake badCake;
    StrictMap empty;
    Bakery bakery;
    Impl impl;
    Nu nu;

    public void fixtures() {
        Wirer haltWirer = impl.impl(HaltOnErrorWirer.class);
        haltWirer.wire(noConfig);
        noConfig = nu.nu(Config.class, empty);
        badCake = bakery.cake(1, 8, "chocolate");
        gargler = nu.nu(Gargler.class);
    }

    public void testHaltOnError() {
        try {
            gargler.slosh(noConfig, badCake);
            fail();
        } catch (InconsistentSliceException expected) {
        }
    }
}
