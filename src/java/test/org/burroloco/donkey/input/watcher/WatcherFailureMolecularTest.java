package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.spider.api.runtime.Resolver;
import org.burroloco.config.core.Config;
import org.burroloco.config.override.instance.Overrider;
import org.burroloco.donkey.config.InputDirName;
import org.burroloco.donkey.config.WatchInterval;
import org.burroloco.donkey.core.WatchingDonkey;
import org.burroloco.donkey.trebuchet.Donkey;
import org.burroloco.test.glue.testcase.TsrTestCase;

public class WatcherFailureMolecularTest extends TsrTestCase implements HasFixtures {
    private static final String DODGY = "foo";
    private Donkey subject;
    private Config config;
    StrictMap<String, String> empty;
    Overrider overrider;
    Resolver resolver;
    Spinneret spinneret;
    Impl impl;
    Nu nu;

    public void fixtures() {
        config = config();
        spinneret.spin(DirWatcherWeb.class);
        subject = impl.impl(WatchingDonkey.class);
    }

    public void testDodgyPullDir() {
        try {
            subject.eat(config);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(DODGY + " is not a valid directory.", e.getMessage());
        }
    }

    private Config config() {
        Config config = nu.nu(Config.class, empty);
        config = overrider.override(config, InputDirName.class, DODGY);
        config = overrider.override(config, WatchInterval.class, 500L);
        return config;
    }
}
