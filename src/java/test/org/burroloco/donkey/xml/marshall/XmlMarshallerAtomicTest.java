package org.burroloco.donkey.xml.marshall;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import java.io.File;

public class XmlMarshallerAtomicTest extends DonkeyTestCase implements HasFixtures {

    private static final File XML = new File("data/expected/employee.xml");
    private Employee employee;
    private String expected;

    FileUtilsStatic files;
    XmlMarshaller subject;

    public void fixtures() {
        expected = files.readFileToString(XML);
        employee = new Employee();
        populateEmployee();
    }

    public void testMarshall() {
        String actual = subject.marshall(employee);
        assertEquals(expected, actual);
    }

    private void populateEmployee() {
        employee.setName("Matt");
        employee.setEmail("matt@navigo.com.au");
    }
}
