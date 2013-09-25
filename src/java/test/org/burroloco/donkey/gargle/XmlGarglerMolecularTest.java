package org.burroloco.donkey.gargle;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.DefaultData;
import org.burroloco.donkey.data.core.DefaultTuple;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import java.util.List;

public class XmlGarglerMolecularTest extends DonkeyTestCase implements HasFixtures {

    //    private static final File XML = new File("data/expected/employee.xml");
//    private String expected;
    private Data data;

    FileUtilsStatic files;
    XmlGargler subject;

    public void fixtures() {
//        expected = files.readFileToString(XML);
        data = data();
    }

    public void testGargle() {
        Data actual = subject.gargle(null, data);
        List<Tuple> tuples = actual.tuples();
        check(tuples);
    }

    private void check(List<Tuple> tuples) {
        assertEquals(3, tuples.size());
        for (Tuple tuple : tuples) {
            assertNotNull(tuple);
        }
    }

    private Data data() {
        Data data = new DefaultData();
        for (int i = 0; i < 3; i++) add(data);
        return data;
    }

    private void add(Data data) {
        Tuple t = tuple();
        data.add(t);
    }

    private Tuple tuple() {
        Tuple t = new DefaultTuple();
        t.add("name", "Matt");
        t.add("email", "matt@navigo.com.au");
        return t;
    }
}