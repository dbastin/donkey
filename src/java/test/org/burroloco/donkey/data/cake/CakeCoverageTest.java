package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.error.ColumnMismatchException;
import org.burroloco.donkey.data.error.NoDataException;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class CakeCoverageTest extends DonkeyTestCase implements HasFixtures {
    private Tuple firstTuple;
    private Tuple otherTuple;
    private Tuple extraTuple;
    Data subject;
    Nu nu;

    public void fixtures() {
        firstTuple = slice("1", "2");
        otherTuple = slice("1", "3");
        extraTuple = slice("1", "2");
    }

    public void testColumnNamesFailsWithNoSlices() {
        try {
            subject.columnNames();
            fail();
        } catch (NoDataException e) {
            // expected
        }
    }

    public void testRefrigerateWithNoSlices() {
        try {
            subject.readOnly();
            fail();
        } catch (NoDataException e) {
            // expected
        }
    }

    public void testModifyAfterRefrigerate() {
        subject.add(firstTuple);
        subject.readOnly();
        try {
            subject.add(extraTuple);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    public void testAddValidatesColumnNames() {
        subject.add(firstTuple);
        try {
            subject.add(otherTuple);
        } catch (ColumnMismatchException e) {
            assertEquals("Expected [1, 2] but was [1, 3]", e.getMessage());
        }
    }

    private Tuple slice(String name1, String name2) {
        Tuple tuple = nu.nu(Tuple.class);
        tuple.add(name1, "nom");
        tuple.add(name2, "nom");
        return tuple;
    }
}
