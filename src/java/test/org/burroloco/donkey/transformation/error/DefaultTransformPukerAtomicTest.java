package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.sniper.marker.LazyFields;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class DefaultTransformPukerAtomicTest extends DonkeyTestCase implements LazyFields {
    TransformPuker subject;
    Slice slice;

    public void testPuker() {
        RuntimeException expected = new RuntimeException("random: " + slice);
        try {
            subject.error(slice, expected);
            fail("Should barf");
        } catch (RuntimeException actual) {
            assertEquals(expected, actual);
        }
    }
}
