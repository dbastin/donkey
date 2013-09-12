package org.burroloco.donkey.data.core;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.error.ColumnMismatchException;
import org.burroloco.donkey.data.error.NoDataException;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class DataCoverageTest extends DonkeyTestCase implements HasFixtures {
    private Tuple firstTuple;
    private Tuple otherTuple;
    private Tuple extraTuple;
    Data subject;
    Nu nu;

    public void fixtures() {
        firstTuple = tuple("1", "2");
        otherTuple = tuple("1", "3");
        extraTuple = tuple("1", "2");
    }

    public void testColumnNamesFailsWithNoTuples() {
        try {
            subject.columnNames();
            fail();
        } catch (NoDataException e) {
            // expected
        }
    }

    public void testReadOnlyWithNoTuples() {
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

    private Tuple tuple(String name1, String name2) {
        Tuple tuple = nu.nu(Tuple.class);
        tuple.add(name1, "value");
        tuple.add(name2, "value");
        return tuple;
    }
}
