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
    private Cake chocolate;
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
        List<Slice> expected = stripe(name, value, SLICES);
        List<Slice> actual = subject.stripe(chocolate, name);
        assertEquals(expected, actual);
    }

    private List<Slice> stripe(String name, Object value, int size) {
        return Collections.nCopies(size, slice(name, value));
    }

    private List<Slice> numbers(String name, int size) {
        List<Slice> l = new ArrayList<Slice>();
        for (int i = 1; i <= size; i++) l.add(slice(name, i));
        return l;
    }

    private Slice slice(String name, Object value) {
        Slice s = nu.nu(Slice.class);
        s.add(name, value);
        return s;
    }
}
