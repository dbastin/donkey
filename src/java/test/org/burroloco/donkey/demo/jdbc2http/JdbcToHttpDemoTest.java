package org.burroloco.donkey.demo.jdbc2http;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.butcher.fixture.database.SourceDatabase;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.trebuchet.TestTrebuchet;

public class JdbcToHttpDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {

    TestTrebuchet trebuchet;
    SourceDatabase database;

    public void fixtures() {
        database.create();
    }

    public void testJdbcToHttp() {
        trebuchet.launch(JdbcToHttpSpecification.class);
    }

    public void destroy() {
        database.drop();
    }
}
