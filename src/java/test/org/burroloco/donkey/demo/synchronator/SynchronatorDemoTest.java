package org.burroloco.donkey.demo.synchronator;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.synchronator.Subject;
import org.burroloco.donkey.synchronator.Synchronator;
import org.burroloco.donkey.synchronator.SynchronatorWirer;
import org.burroloco.butcher.fixture.database.InputDatabase;
import org.burroloco.butcher.util.file.FileComparator;

import java.io.File;

public class SynchronatorDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {
    private static final File EXPECTED_DELETE = new File("data/expected/employee-delete.csv");
    private static final File EXPECTED_INSERT = new File("data/expected/employee-insert.csv");
    private static final File ACTUAL_DELETE = new File("gen/demo/out/employee-delete.csv");
    private static final File ACTUAL_INSERT = new File("gen/demo/out/employee-insert.csv");
    private Synchronator subject;
    FileComparator comparator;
    SynchronatorWirer wirer;
    InputDatabase source;
    ConfigLoader loader;
    Nu nu;

    public void fixtures() {
        wirer.wire();
        source.create();
        subject = nu.nu(Synchronator.class);
    }

    public void testDataSynch() {
        Subject s = nu.nu(Subject.class, "employee", new String[]{"ID"});
        Config c = loader.load("config/synchronator/synchronator.properties");
        subject.sync(s, c);
        check();
    }

    // FIX DONKEY WIP... These files aren't right. Slice equals is not behaving properly.
    private void check() {
        comparator.assertEquals(EXPECTED_DELETE, ACTUAL_DELETE);
        comparator.assertEquals(EXPECTED_INSERT, ACTUAL_INSERT);
    }

    public void destroy() {
        source.drop();
    }
}
