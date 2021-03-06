package org.burroloco.donkey.demo.synchronator;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.butcher.fixture.database.SourceDatabase;
import org.burroloco.butcher.util.file.FileComparator;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.synchronator.Subject;
import org.burroloco.donkey.synchronator.Synchronator;
import org.burroloco.donkey.synchronator.SynchronatorWirer;

import java.io.File;

/**
 * Using the Donkey to calculate DB data diffs.
 * Good for database source control.
 */
public class SynchronatorDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {
    private Synchronator subject;
    FileComparator comparator;
    SynchronatorWirer wirer;
    SourceDatabase source;
    Nu nu;

    public void fixtures() {
        source.create();
        wirer.wire();
        subject = nu.nu(Synchronator.class);
    }

    public void testFirstTime() {
        synch("address");
        check("address-insert.sql");
    }

    public void testDelta() {
        synch("employee");
        check("employee-delete.sql");
        check("employee-update.sql");
        check("employee-insert.sql");
    }

    private void synch(String subjectName) {
        Subject s = nu.nu(Subject.class, subjectName, new String[]{"ID"});
        subject.sync(s);
    }

    private void check(String name) {
        File e = new File("data/expected/synchronator/" + name);
        File a = new File("gen/demo/out/" + name);
        comparator.assertEquals(e, a);
    }

    public void destroy() {
        source.drop();
    }
}
