package org.burroloco.donkey.xml.marshal;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.butcher.fixture.harness.Harness;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import java.io.File;

public class XmlMarshallerAtomicTest extends DonkeyTestCase implements HasFixtures {

    private static final File XML = new File("data/expected/employee-1.xml");
    private Employee employee;
    private String expected;

    FileUtilsStatic files;
    XmlMarshaller subject;
    Harness harness;

    public void fixtures() {
        expected = files.readFileToString(XML);
        employee = harness.employee();
    }

    public void testMarshall() {
        String actual = subject.marshal(employee);
        assertEquals(expected, actual);
    }
}
