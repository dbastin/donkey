package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import static org.burroloco.donkey.data.cake.Bakery.KEYS;
import org.burroloco.test.glue.testcase.TsrTestCase;

public class DefaultPatissierAtomicTest extends TsrTestCase implements HasFixtures, LazyFields {
    Patissier subject;
    Cake leftUnique;
    Cake leftChanges;
    Cake rightChanges;
    Cake rightUnique;
    String whatever;
    Bakery bakery;
    Cake none;
    Cake same;
    Cake left;
    Cake right;
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

    private Cake moosh(Cake...pieces) {
        Cake c = nu.nu(Cake.class);
        for (Cake piece : pieces) c.addAll(piece.slices());
        return c;
    }
}
