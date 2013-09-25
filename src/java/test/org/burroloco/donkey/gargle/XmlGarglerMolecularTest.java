package org.burroloco.donkey.gargle;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.butcher.fixture.harness.Harness;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.DefaultData;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import java.io.File;
import java.util.List;

import static org.burroloco.donkey.data.core.Tuple.UNIT_KEY;

public class XmlGarglerMolecularTest extends DonkeyTestCase implements HasFixtures {

    private static final File XML = new File("data/expected/employee-1.xml");
    private String expected;
    private Config config;
    private Data data;

    FileUtilsStatic files;
    ConfigLoader loader;
    XmlGargler subject;
    Harness harness;

    public void fixtures() {
        data = data();
        config = loader.load("config/jdbc2http/jdbc2http.properties");
        expected = files.readFileToString(XML);
    }

    public void testGargle() {
        Data actual = subject.gargle(config, data);
        List<Tuple> tuples = actual.tuples();
        check(tuples);
    }

    private void check(List<Tuple> tuples) {
        assertEquals(3, tuples.size());
        for (Tuple tuple : tuples) {
            String xml = (String) tuple.value(UNIT_KEY);
            assertEquals(expected, xml);
        }
    }

    private Data data() {
        Data data = new DefaultData();
        for (int i = 0; i < 3; i++) add(data);
        return data;
    }

    private void add(Data data) {
        Tuple t = harness.tuple();
        data.add(t);
    }
}