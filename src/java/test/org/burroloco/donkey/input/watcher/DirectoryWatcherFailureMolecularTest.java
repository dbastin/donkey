package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.gunge.collection.DefaultStrictMap;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.demo.watcher.DirectoryWatcherWirer;
import org.burroloco.donkey.config.InputDirName;
import org.burroloco.donkey.config.PollingInterval;
import org.burroloco.donkey.trebuchet.Sling;
import org.burroloco.donkey.trebuchet.Wirer;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class DirectoryWatcherFailureMolecularTest extends DonkeyTestCase implements HasFixtures {
    private static final String DODGY = "foo";
    private Config config;
    Spinneret spinneret;
    Sling subject;
    Impl impl;
    Nu nu;

    public void fixtures() {
        config = config();
        Wirer wirer = impl.impl(DirectoryWatcherWirer.class);
        wirer.wire(config);
    }

    public void testDodgyWatchDir() {
        try {
            subject.release(config);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(DODGY + " is not a valid directory.", e.getMessage());
        }
    }

    private Config config() {
        StrictMap config = new DefaultStrictMap();
        config.put(InputDirName.NAME, DODGY);
        config.put(PollingInterval.NAME, 500L);
        return nu.nu(Config.class, config);
    }
}
