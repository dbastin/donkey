package org.burroloco.donkey.hydrator;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.donkey.data.core.DefaultTuple;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.xml.marshall.Employee;

public class HydratorMolecularTest extends DonkeyTestCase implements HasFixtures{

    private static final String EMAIL = "matt@navigo.com.au";
    private static final String NAME = "Matt";
    private Employee expected;
    private Tuple tuple;

    Hydrator subject;

    public void fixtures() {
        expected = employee();
        tuple = new DefaultTuple();
        tuple.add("name", NAME);
        tuple.add("email", EMAIL);
    }

    public void testHydrate() {
        Employee actual = subject.hydrate(tuple, Employee.class);
        assertEquals(expected, actual);
    }

    private Employee employee() {
        Employee e = new Employee();
        populateEmployee(e);
        return e;
    }

    private void populateEmployee(Employee e) {
        e.setEmail(EMAIL);
        e.setName(NAME);
    }
}
