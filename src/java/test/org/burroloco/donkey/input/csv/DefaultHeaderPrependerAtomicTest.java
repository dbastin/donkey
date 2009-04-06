package org.burroloco.donkey.input.csv;

import org.burroloco.test.glue.testcase.TsrTestCase;

import java.util.ArrayList;
import java.util.List;

public class DefaultHeaderPrependerAtomicTest extends TsrTestCase {
    private static final Object[] EXPECTED_HEADER = new Object[]{"0", "1", "2"};
    private static final Object[] FIRST_ROW = new String[]{"a", "b", "c"};
    private List rows = new ArrayList();
    HeaderPrepender subject;

    public void testSuccess() {
        rows.add(FIRST_ROW);
        List actual = subject.prepend(rows);
        check(actual);
    }

    public void testFailure() {
        try {
            subject.prepend(rows);
            fail("No Exception thrown from HeaderPrepender");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    private void check(List actual) {
        assertEquals(2, actual.size());
        assertEquals(EXPECTED_HEADER, (Object[]) actual.get(0));
        assertEquals(FIRST_ROW, actual.get(1));
    }
}
