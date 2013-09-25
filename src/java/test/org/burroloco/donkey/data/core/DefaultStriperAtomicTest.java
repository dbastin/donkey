package org.burroloco.donkey.data.core;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.burroloco.donkey.data.core.DataGenerator.KEYS;

public class DefaultStriperAtomicTest extends DonkeyTestCase implements HasFixtures {
    private static final int TUPLES = 8;
    private Data data;

    DataGenerator generator;
    Striper subject;
    Nu nu;

    public void fixtures() {
        data = generator.data(1, TUPLES, "meep");
    }

    public void testStriping() {
        checkStripe("anotherValue", "meep");
        checkStripe("yetAnotherValue", "aarp");
        assertEquals(numbers("key", TUPLES), subject.stripe(data, KEYS));
    }

    private void checkStripe(String name, String value) {
        List<Tuple> expected = stripe(name, value, TUPLES);
        List<Tuple> actual = subject.stripe(data, name);
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
