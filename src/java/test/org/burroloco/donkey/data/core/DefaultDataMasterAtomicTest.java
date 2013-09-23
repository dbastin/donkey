package org.burroloco.donkey.data.core;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import static org.burroloco.donkey.data.core.Bakery.KEYS;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class DefaultDataMasterAtomicTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    DataMaster subject;
    Data leftUnique;
    Data leftChanges;
    Data rightChanges;
    Data rightUnique;
    String whatever;
    Bakery bakery;
    Data none;
    Data both;
    Data left;
    Data right;
    Nu nu;

    public void fixtures() {
        leftUnique = bakery.cake(1, 2, whatever);
        both = bakery.cake(3, 4, "same");
        leftChanges = bakery.cake(5, 6, "left");
        rightChanges = bakery.cake(5, 6, "right");
        rightUnique = bakery.cake(7, 8, whatever);
        left = moosh(leftUnique, both, leftChanges);
        right = moosh(both, rightChanges, rightUnique);
    }

    public void testIntersection() {
        assertEquals(both, subject.intersection(left, right));
        assertEquals(both, subject.intersection(right, left));
        assertEquals(left, subject.intersection(left, left));
        assertEquals(none, subject.intersection(left, none));
    }

    public void testMinus() {
        assertEquals(leftUnique, subject.minus(left, right, KEYS));
        assertEquals(rightUnique, subject.minus(right, left, KEYS));
        assertEquals(none, subject.minus(left, left, KEYS));
        assertEquals(left, subject.minus(left, none, KEYS));
    }

    public void testDiffs(){
        assertEquals(leftChanges, subject.diffs(left, right, KEYS));
        assertEquals(rightChanges, subject.diffs(right, left, KEYS));
        assertEquals(none, subject.diffs(left, left, KEYS));
    }

    private Data moosh(Data...pieces) {
        Data c = nu.nu(Data.class);
        for (Data piece : pieces) c.addAll(piece.tuples());
        return c;
    }
}