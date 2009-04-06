package org.burroloco.donkey.data.check;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.data.error.InconsistentSliceException;
import org.burroloco.test.glue.testcase.TsrTestCase;

public class DefaultSliceCheckerAtomicTest extends TsrTestCase implements HasFixtures, LazyFields {
    SliceChecker subject;
    Slice dodgySlice;
    Impl impl;

    public void fixtures() {
        dodgySlice();
    }

    public void testInconsistentColumns() {
        try {
            subject.check(dodgySlice, 100);
            fail("Dodgy number of columns not detected");
        } catch (InconsistentSliceException e) {
            assertEquals("Expected slice with 100 columns but got 3 column(s) " +
                    "like this: {one=whatever, two=whatever, three=whatever}", e.getMessage());
        }
    }

    private void dodgySlice() {
        dodgySlice.add("one", "whatever");
        dodgySlice.add("two", "whatever");
        dodgySlice.add("three", "whatever");
    }

}
