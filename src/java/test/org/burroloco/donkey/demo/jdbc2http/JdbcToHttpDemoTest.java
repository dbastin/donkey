package org.burroloco.donkey.demo.jdbc2http;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import org.burroloco.butcher.fixture.database.SourceDatabase;
import org.burroloco.butcher.fixture.http.HttpServer;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.trebuchet.TestTrebuchet;

public class JdbcToHttpDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {

    SourceDatabase database;
    TestTrebuchet trebuchet;
    HttpServer server;

    public void fixtures() {
        database.create();
        server.start();
    }

    public void testJdbcToHttp() {
        trebuchet.launch(JdbcToHttpSpecification.class);
        check();
    }

    private void check() {
        String actual = server.payload();
        String expected = "Hello World";
        assertEquals(expected, actual);
    }

    public void destroy() {
        database.drop();
        server.stop();
    }
}
