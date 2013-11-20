package org.burroloco.donkey.hydrator;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.butcher.fixture.harness.Harness;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.xml.marshal.Employee;

public class DehydratorMolecularTest extends DonkeyTestCase implements HasFixtures {

    private Employee employee;
    private Tuple expected;

    Dehydrator subject;
    Harness harness;

    public void fixtures() {
        expected = harness.tuple();
        employee = harness.employee();
    }

    public void testHydrate() {
        Tuple actual = subject.dehydrate(employee);
        assertEquals(expected, actual);
    }
}
