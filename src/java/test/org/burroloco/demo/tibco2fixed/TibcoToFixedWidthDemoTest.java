package org.burroloco.demo.tibco2fixed;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.test.butcher.fixture.tibco.Publisher;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.test.util.io.FileComparator;
import org.burroloco.util.snooze.Snoozer;

import java.io.File;
import java.util.Map;

public class TibcoToFixedWidthDemoTest extends DonkeyTestCase implements HasFixtures {
    private static final File EXPECTED = new File("data/expected/employee.fixed");
    private static final File ACTUAL = new File("gen/test/out/employee.fixed");
    Map<String, Object> payload;
    FileComparator comparator;
    Publisher publisher;
    Trebuchet trebuchet;
    Snoozer snoozer;

    public void testTibcoToFixedWidth() {
        trebuchet.launch(TibcoToFixedWidthSpecification.class);
        publisher.send("tibco.to.fixed.width.demo.test", payload);
        snoozer.snooze(1000);
        // FIX DONKEY Figure out the whole tibby thing and reinstate.
//        comparator.assertEquals(EXPECTED, ACTUAL);
    }

    public void fixtures() {
       payload.put("ID", "1");
       payload.put("NAME", "Fred");
    }
}
