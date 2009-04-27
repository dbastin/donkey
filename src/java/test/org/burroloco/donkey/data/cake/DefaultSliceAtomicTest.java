package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.error.MissingValueException;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class DefaultSliceAtomicTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    private static final String DUPLICATE_KEY = "a";
    private static final String EXPECTED_MESSAGE = "Value for '" + DUPLICATE_KEY + "' already set";
    Slice subject;
    String random;
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

    public void testMissingKey() {
        try {
            subject.value(random);
        } catch (MissingValueException e) {
            assertEquals("There is no key '" + random + "'", e.getMessage());

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
