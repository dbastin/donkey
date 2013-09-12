package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import static org.burroloco.donkey.data.cake.Bakery.KEYS;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class DefaultPatissierAtomicTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    Patissier subject;
    Data leftUnique;
    Data leftChanges;
    Data rightChanges;
    Data rightUnique;
    String whatever;
    Bakery bakery;
    Data none;
    Data same;
    Data left;
    Data right;
    Nu nu;

    public void fixtures() {
        leftUnique = bakery.cake(1, 2, whatever);
        same = bakery.cake(3, 4, "same");
        leftChanges = bakery.cake(5, 6, "left");
        rightChanges = bakery.cake(5, 6, "right");
        rightUnique = bakery.cake(7, 8, whatever);
        left = moosh(leftUnique, same, leftChanges);
        right = moosh(same, rightChanges, rightUnique);
    }

    public void testSameness() {
        assertEquals(same, subject.same(left, right));
        assertEquals(same, subject.same(right, left));
        assertEquals(left, subject.same(left, left));
        assertEquals(none, subject.same(left, none));
    }

    public void testMinus() {
        assertEquals(leftUnique, subject.minus(left, right, KEYS));
        assertEquals(rightUnique, subject.minus(right, left, KEYS));
        assertEquals(none, subject.minus(left, left, KEYS));
        assertEquals(left, subject.minus(left, none, KEYS));
    }

    public void testChanges(){
        assertEquals(leftChanges, subject.changes(left, right, KEYS));
        assertEquals(rightChanges, subject.changes(right, left, KEYS));
        assertEquals(none, subject.changes(left, left, KEYS));
    }

    private Data moosh(Data...pieces) {
        Data c = nu.nu(Data.class);
        for (Data piece : pieces) c.addAll(piece.tuples());
        return c;
    }
}
