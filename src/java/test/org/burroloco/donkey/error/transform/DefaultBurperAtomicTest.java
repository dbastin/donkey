package org.burroloco.donkey.error.transform;

import au.net.netstorm.boost.sniper.marker.LazyFields;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class DefaultBurperAtomicTest extends DonkeyTestCase implements LazyFields {
    ErrorHandler subject;
    Tuple tuple;

    public void testBurper() {
        RuntimeException expected = new RuntimeException("random: " + tuple);
        try {
            subject.handle(tuple, expected);
            fail("Should have burped");
        } catch (RuntimeException actual) {
            assertEquals(expected, actual);
        }
    }
}
