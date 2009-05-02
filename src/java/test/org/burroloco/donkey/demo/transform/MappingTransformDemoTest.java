package org.burroloco.donkey.demo.transform;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.butcher.fixture.database.InputDatabase;
import org.burroloco.butcher.util.file.FileComparator;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.trebuchet.Trebuchet;

import java.io.File;

public class MappingTransformDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {
    private static final File EXPECTED = new File("data/expected/fullname.csv");
    private static final File ACTUAL = new File("gen/demo/out/fullname.csv");
    FileComparator comparator;
    InputDatabase database;
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