package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import static org.burroloco.donkey.data.cake.Bakery.KEYS;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultStriperAtomicTest extends DonkeyTestCase implements HasFixtures {
    private static final int SLICES = 8;
    private Data chocolate;
    Striper subject;
    Bakery bakery;
    Nu nu;

    public void fixtures() {
        chocolate = bakery.cake(1, SLICES, "chocolate");
    }

    public void testStriping() {
        checkStripe("flavour", "chocolate");
        checkStripe("some.Ref", "egg");
        assertEquals(numbers("key", SLICES), subject.stripe(chocolate, KEYS));
    }

    private void checkStripe(String name, String value) {
        List<Tuple> expected = stripe(name, value, SLICES);
        List<Tuple> actual = subject.stripe(chocolate, name);
        assertEquals(expected, actual);
    }

    private List<Tuple> stripe(String name, Object value, int size) {
        return Collections.nCopies(size, slice(name, value));
    }

    private List<Tuple> numbers(String name, int size) {
        List<Tuple> l = new ArrayList<Tuple>();
        for (int i = 1; i <= size; i++) l.add(slice(name, i));
        return l;
    }

    private Tuple slice(String name, Object value) {
        Tuple s = nu.nu(Tuple.class);
        s.add(name, value);
        return s;
    }
}
