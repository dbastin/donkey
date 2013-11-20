package org.burroloco.donkey.xml.marshal;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.butcher.fixture.harness.Harness;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.xml.unmarshal.XmlUnmarshaller;

import java.io.File;

public class XmlUnmarshallerAtomicTest extends DonkeyTestCase implements HasFixtures {
    private static final File XML = new File("data/expected/employee-1.xml");
    private Employee expected;
    private String xml;

    XmlUnmarshaller subject;
    FileUtilsStatic files;
    Harness harness;

    public void fixtures() {
        xml = files.readFileToString(XML);
        expected = harness.employee();
    }

    public void testUnmarshal() {
        Employee actual = (Employee) subject.unmarshal(Employee.class, xml);
        assertEquals(expected, actual);
    }
}
