package org.burroloco.donkey.hydrator;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.butcher.fixture.harness.Harness;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.xml.marshal.Employee;

public class HydratorMolecularTest extends DonkeyTestCase implements HasFixtures{

    private Employee expected;
    private Tuple tuple;

    ThrowableMaster chuckie;
    Hydrator subject;
    Harness harness;

    public void fixtures() {
        expected = harness.employee();
        tuple = harness.tuple();
    }

    public void testHydrate() {
        Employee actual = subject.hydrate(tuple, Employee.class);
        assertEquals(expected, actual);
    }

    public void testDodgyHydrate() {
        try {
            subject.hydrate(tuple, Blah.class);
            fail();
        } catch (RuntimeException e) {
            Throwable c = chuckie.realCause(e);
            String expected = "There is no method [setId] in [org.burroloco.donkey.hydrator.Blah]";
            assertEquals(expected, c.getMessage());
        }
    }
}
