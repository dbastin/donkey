package org.burroloco.donkey.demo.jdbc2csv;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.butcher.fixture.database.InputDatabase;
import org.burroloco.butcher.util.file.FileComparator;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.trebuchet.Trebuchet;

import java.io.File;

public class JdbcToCsvDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {
    private static final File EXPECTED = new File("data/expected/employee.csv");
    private static final File ACTUAL = new File("gen/demo/out/employee.csv");
    FileComparator comparator;
    InputDatabase database;
    Trebuchet trebuchet;
    
    public void fixtures() {
        database.create();
    }

    public void testJdbcToCvs() {
        trebuchet.launch(JdbcToCsvSpecification.class);
        comparator.assertEquals(EXPECTED, ACTUAL);
    }

    public void destroy() {
        database.drop();
    }
}
