package org.burroloco.demo.jdbc2jdbc;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.demo.common.LeftDatabase;
import org.burroloco.demo.common.RightDatabase;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class JdbcToJdbcDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {
    LeftDatabase source;
    RightDatabase target;
    Trebuchet trebuchet;

    // FIX TSR-DONKEY WIP. Please leave.
    // FIX TSR-DONKEY Trying to drive out different source and target config params.
    // FIX TSR-DONKEY Changing the source db and the target db soon...
    public void fixtures() {
        source.create();
        target.create();
    }

    public void testJdbcToJdbc() {
        trebuchet.launch(JdbcToJdbcSpecification.class);
        check();
    }

    private void check() {
        int count = target.count("new_employee");
        // FIX TSR-DONKEY Reinstate...
//        assertEquals(4, count);
    }

    public void destroy() {
        source.drop();
        target.drop();
    }
}
