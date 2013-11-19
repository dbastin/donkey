package org.burroloco.donkey.demo.jdbc2https;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.butcher.fixture.checker.database.ProcessedChecker;
import org.burroloco.butcher.fixture.database.SourceDatabase;
import org.burroloco.butcher.fixture.http.TargetHttpServer;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.trebuchet.TestTrebuchet;

import java.io.File;
import java.util.List;

public class JdbcToHttpsDemoTest extends DonkeyTestCase implements HasFixtures, Destroyable {

    private static final String BASE = "data/expected/employee";

    ProcessedChecker processed;
    TargetHttpServer server;
    SourceDatabase database;
    TestTrebuchet trebuchet;
    FileUtilsStatic files;

    public void fixtures() {
        database.create();
        server.start();
    }

    public void testJdbcToHttp() {
        processed.check(0);
        trebuchet.launch(JdbcToHttpsSpecification.class);
        checkRequests();
        // TODO - AAAAAAAAAAAAAA Drive this out...
//        processed.check(5);
    }

    private void checkRequests() {
        List<String> requests = server.requests();
        assertEquals(5, requests.size());
        for (int i = 1; i <= requests.size(); i++) {
            String expected = readEmployee(i);
            String actual = requests.get(i - 1);
            assertEquals(expected, actual);
        }
    }

    private String readEmployee(int index) {
        String name = BASE + "-" + index + ".xml";
        File file = new File(name);
        return files.readFileToString(file);
    }

    public void destroy() {
        database.drop();
        server.stop();
    }
}
