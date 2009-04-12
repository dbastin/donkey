package org.burroloco.tibco.dispatcher;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.com.tibco.tibrv.TibrvDispatcher;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.tibco.config.TestTibcoWirer;

public class DefaultTibcoDispatcherAtomicTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    private TibcoDispatcher subject;
    TibrvDispatcher dispatcherMock;
    TestTibcoWirer tibcoWirer;
    Nu nu;

    public void fixtures() {
        tibcoWirer.wire();
        subject = nu.nu(TibcoDispatcher.class, dispatcherMock);
    }

    public void testResolvedDispatcherCallsJoin() {
        expect.oneCall(dispatcherMock, VOID, "join");
        subject.join();
    }
}
