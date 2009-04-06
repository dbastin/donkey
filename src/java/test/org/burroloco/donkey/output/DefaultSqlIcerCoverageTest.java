package org.burroloco.donkey.output;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.data.error.UnsupportedTypeException;
import org.burroloco.donkey.output.ice.SqlIcer;
import org.burroloco.test.glue.testcase.TsrTestCase;

import java.util.Random;

public class DefaultSqlIcerCoverageTest extends TsrTestCase implements HasFixtures {
    private static final String NAME = "UnsupportedType";
    private static final Random VALUE = new Random();
    SqlIcer subject;
    Slice slice;
    Cake in;

    public void fixtures() {
        slice.add(NAME, VALUE);
        in.add(slice);
    }

    public void testException() {
        try {
            subject.transform(in);
            fail();
        } catch (UnsupportedTypeException e) {
            assertEquals("Cannot convert value of type " + VALUE.getClass() + " for '" + NAME + "'.", e.getMessage());
        }
    }
}
