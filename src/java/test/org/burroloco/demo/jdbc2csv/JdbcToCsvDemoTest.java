package org.burroloco.demo.jdbc2csv;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.sql.Connection;
import edge.java.sql.Statement;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.test.util.io.FileComparator;

import java.io.File;

public class JdbcToCsvDemoTest extends DonkeyTestCase implements HasFixtures {
    private static final File EXPECTED = new File("data/expected/employee.csv");
    private static final File ACTUAL = new File("gen/demo/out/employee.csv");
    FileComparator comparator;
    Trebuchet trebuchet;
    Nu nu;

    public void fixtures() {
        Connection c = nu.nu(Connection.class, "jdbc:hsqldb:mem:employee", "sa", "", "org.hsqldb.jdbcDriver");
        Statement s = c.createStatement();
        s.execute("create table employee(id int, name varchar)");
        s.execute("insert into EMPLOYEE (ID, NAME) values (1, 'Fred');");
        s.execute("insert into EMPLOYEE (ID, NAME) values (2, 'Wilma');");
        s.execute("insert into EMPLOYEE (ID, NAME) values (3, 'Barney');");
        s.execute("insert into EMPLOYEE (ID, NAME) values (4, 'Betty');");
    }

    public void testJdbcToCvs() {
        trebuchet.launch(JdbcToCsvSpecification.class);
        comparator.assertEquals(EXPECTED, ACTUAL);
    }
}
