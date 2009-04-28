package org.burroloco.donkey.demo.jdbc2jdbc;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.butcher.fixture.database.InputDatabase;
import org.burroloco.butcher.fixture.database.OutputDatabase;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class JdbcToJdbcDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {
    InputDatabase source;
    OutputDatabase target;
    Trebuchet trebuchet;

    public void fixtures() {
        source.create();
        target.create();
    }

    public void testJdbcToJdbc() {
        trebuchet.launch(JdbcToJdbcSpecification.class);
        check();
    }

    private void check() {
        int expected = source.count("EMPLOYEE");
        int actual = target.count("EMP");
        assertEquals(expected, actual);
    }

    public void destroy() {
        source.drop();
        target.drop();
    }
}
