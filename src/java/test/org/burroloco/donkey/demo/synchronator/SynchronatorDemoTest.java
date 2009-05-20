package org.burroloco.donkey.demo.synchronator;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.synchronator.Subject;
import org.burroloco.donkey.synchronator.Synchronator;
import org.burroloco.donkey.synchronator.SynchronatorWirer;
import org.burroloco.butcher.fixture.database.InputDatabase;
import org.burroloco.butcher.util.file.FileComparator;

import java.io.File;

public class SynchronatorDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {
    private Synchronator subject;
    FileComparator comparator;
    SynchronatorWirer wirer;
    InputDatabase source;
    ConfigLoader loader;
    Nu nu;

    public void fixtures() {
        source.create();
        wirer.wire();
        subject = nu.nu(Synchronator.class);
    }

    public void testFirstTime() {
        synch("address");
        // check("address-insert.csv");
    }

    public void testDelta() {
        synch("employee");
        check("employee-delete.csv");
        check("employee-update.csv");
        check("employee-insert.csv");
    }

    private void synch(String subjectName) {
        Subject s = nu.nu(Subject.class, subjectName, new String[]{"ID"});
        subject.sync(s);
    }

    private void check(String name) {
        File e = new File("data/expected/" + name);
        File a = new File("gen/demo/out/" + name);
        comparator.assertEquals(e, a);
    }

    public void destroy() {
        source.drop();
    }
}
