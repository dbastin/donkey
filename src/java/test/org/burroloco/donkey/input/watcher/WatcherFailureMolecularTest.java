package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.config.override.instance.Overrider;
import org.burroloco.demo.watcher.DirectoryWatcherWirer;
import org.burroloco.donkey.config.InputDirName;
import org.burroloco.donkey.config.PollingInterval;
import org.burroloco.donkey.loop.Loop;
import org.burroloco.donkey.loop.SimpleLoop;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class WatcherFailureMolecularTest extends DonkeyTestCase implements HasFixtures {
    private static final String DODGY = "foo";
    private Config config;
    private Loop subject;
    StrictMap<String, String> empty;
    Spinneret spinneret;
    Overrider overrider;
    Impl impl;
    Nu nu;

    public void fixtures() {
        config = config();
        // FIX TSR-DONKEY Cyclic dependency with Demo test package to be removed when Loop is removed.
        Wirer wirer = impl.impl(DirectoryWatcherWirer.class);
        wirer.wire(config);
        subject = impl.impl(SimpleLoop.class);
    }

    public void testDodgyWatchDir() {
        try {
            subject.go(config);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(DODGY + " is not a valid directory.", e.getMessage());
        }
    }

    private Config config() {
        Config config = nu.nu(Config.class, empty);
        config = overrider.override(config, InputDirName.class, DODGY);
        config = overrider.override(config, PollingInterval.class, 500L);
        return config;
    }
}
