package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.error.ColumnMismatchException;
import org.burroloco.donkey.data.error.EmptyCakeException;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class CakeCoverageTest extends DonkeyTestCase implements HasFixtures {
    private Slice firstSlice;
    private Slice otherSlice;
    private Slice extraSlice;
    Cake subject;
    Nu nu;

    public void fixtures() {
        firstSlice = slice("1", "2");
        otherSlice = slice("1", "3");
        extraSlice = slice("1", "2");
    }

    public void testColumnNamesFailsWithNoSlices() {
        try {
            subject.columnNames();
            fail();
        } catch (EmptyCakeException e) {
            // expected
        }
    }

    public void testRefrigerateWithNoSlices() {
        try {
            subject.refrigerate();
            fail();
        } catch (EmptyCakeException e) {
            // expected
        }
    }

    public void testModifyAfterRefrigerate() {
        subject.add(firstSlice);
        subject.refrigerate();
        try {
            subject.add(extraSlice);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    public void testAddValidatesColumnNames() {
        subject.add(firstSlice);
        try {
            subject.add(otherSlice);
        } catch (ColumnMismatchException e) {
            assertEquals("Expected [1, 2] but was [1, 3]", e.getMessage());
        }
    }

    private Slice slice(String name1, String name2) {
        Slice slice = nu.nu(Slice.class);
        slice.add(name1, "nom");
        slice.add(name2, "nom");
        return slice;
    }
}
