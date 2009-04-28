package org.burroloco.donkey.error.transform;

import au.net.netstorm.boost.sniper.marker.LazyFields;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class DefaultBurperAtomicTest extends DonkeyTestCase implements LazyFields {
    Burper subject;
    Slice slice;

    public void testBurper() {
        RuntimeException expected = new RuntimeException("random: " + slice);
        try {
            subject.error(slice, expected);
            fail("Should have burped");
        } catch (RuntimeException actual) {
            assertEquals(expected, actual);
        }
    }
}
