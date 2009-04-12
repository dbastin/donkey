package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.error.EmptyCakeException;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class DefaultSingleResultQueryCoverageTest extends DonkeyTestCase implements LazyFields, InjectableSubject {
    private Exception exception = new EmptyCakeException("whatever");
    SingleResultQuery subject = new DefaultSingleResultQuery();
    QueryRunnerEngine engineMock;
    Config configDummy;
    String sqlDummy;
    Nu nu;

    public void testEmptyResult() {
        expect.oneCall(engineMock, exception, "query", configDummy, sqlDummy);
        try {
            subject.value(configDummy, sqlDummy);
            fail();
        } catch (QueryException e) {
            assertEquals("Query returned no results: " + sqlDummy, e.getMessage());
        }

    }

    public void testMultipleSlices() {
        Cake cake = nu.nu(Cake.class);
        expect.oneCall(engineMock, cake, "query", configDummy, sqlDummy);
        try {
            subject.value(configDummy, sqlDummy);
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}
