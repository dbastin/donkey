package org.burroloco.demo.transform;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.test.butcher.fixture.database.InputDatabase;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.test.util.io.FileComparator;

import java.io.File;

public class MappingTransformDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {
    private static final File EXPECTED = new File("data/expected/fullnames.csv");
    private static final File ACTUAL = new File("gen/demo/out/fullnames.csv");
    InputDatabase database;
    FileComparator comparator;
    Trebuchet trebuchet;

    public void fixtures() {
        database.create();
    }

    public void testFullNameMapper() {
        trebuchet.launch(TransformSpecification.class);
        comparator.assertEquals(EXPECTED, ACTUAL);
    }

    public void destroy() {
        database.drop();
    }
}