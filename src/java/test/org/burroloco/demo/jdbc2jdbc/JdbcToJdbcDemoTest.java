package org.burroloco.demo.jdbc2jdbc;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.java.sql.ResultSet;
import edge.java.sql.Statement;
import edge.java.sql.Connection;
import org.burroloco.demo.common.EmployeeDatabase;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.test.butcher.fixture.database.MemoryDatabase;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class JdbcToJdbcDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {
    EmployeeDatabase database;
    MemoryDatabase target;
    Trebuchet trebuchet;

    // FIX TSR-DONKEY WIP. Please leave.
    // FIX TSR-DONKEY Trying to drive out different source and target config params.
    // FIX TSR-DONKEY Changing the source db and the target db soon...
    public void fixtures() {
        database.create();
    }

    public void testJdbcToJdbc() {
        trebuchet.launch(JdbcToJdbcSpecification.class);
        check();
    }

    private void check() {
        Connection c = target.connection("employee");
        Statement s = c.createStatement();
        ResultSet results = s.executeQuery("select count(*) from new_employee");
        results.next();
        assertEquals(4, results.getObject(1));
    }

    public void destroy() {
        database.drop();
    }
}
