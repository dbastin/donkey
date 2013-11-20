package org.burroloco.donkey.data.core;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.error.MissingValueException;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class TupleAtomicTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    private static final String DUPLICATE_KEY = "a";
    private static final String EXPECTED_MESSAGE = "Value for '" + DUPLICATE_KEY + "' already set";
    Tuple subject;
    String random;
    Nu nu;

    public void fixtures() {
        subject.add(DUPLICATE_KEY, "one");
    }

    public void testDuplicateKeysNotAllowed() {
        try {
            subject.add(DUPLICATE_KEY, "two");
            fail();
        } catch (Exception e) {
            assertEquals(EXPECTED_MESSAGE, e.getMessage());
        }
    }

    public void testReadOnly() {
        subject.readOnly();
        try {
            subject.add("b", "B");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Tuple is read only.", e.getMessage());
        }
    }

    public void testMissingKey() {
        try {
            subject.value(random);
            fail();
        } catch (MissingValueException e) {
            assertEquals("There is no key '" + random + "'", e.getMessage());
        }
    }

    public void testPutAll() {
        Tuple otherTuple = nu.nu(Tuple.class);
        otherTuple.add("b", "two");
        otherTuple.add("c", "three");
        subject.addAll(otherTuple);
        assertEquals("two", subject.value("b"));
        assertEquals("three", subject.value("c"));
    }

    public void testPutAllWithDuplicateKeyFails() {
        Tuple otherTuple = nu.nu(Tuple.class);
        otherTuple.add(DUPLICATE_KEY, "three");
        try {
            subject.addAll(otherTuple);
            fail();
        } catch (Exception e) {
            assertEquals(EXPECTED_MESSAGE, e.getMessage());
        }
    }
}
