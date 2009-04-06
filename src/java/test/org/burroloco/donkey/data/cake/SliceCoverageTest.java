package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.test.glue.testcase.TsrTestCase;

public class SliceCoverageTest extends TsrTestCase implements HasFixtures {
    private static final String DUPLICATE_KEY = "a";
    private static final String EXPECTED_MESSAGE = "Value for '" + DUPLICATE_KEY + "' already set";
    Slice subject;
    Nu nu;

    public void fixtures() {
        subject.add(DUPLICATE_KEY, "one");
    }

    public void testDuplicateKeysNotAllowed() {
        try {
            subject.add(DUPLICATE_KEY, "two");
        } catch (Exception e) {
            assertEquals(EXPECTED_MESSAGE, e.getMessage());
        }
    }

    public void testPutAllValidatesKeys() {
        Slice otherSlice = nu.nu(Slice.class);
        otherSlice.add(DUPLICATE_KEY, "three");
        try {
            subject.addAll(otherSlice);
        } catch (Exception e) {
            assertEquals(EXPECTED_MESSAGE, e.getMessage());
        }
    }
}
