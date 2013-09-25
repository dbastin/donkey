package org.burroloco.donkey.exception.gargle;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.OverlaysWeb;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class DefaultBurperCoverageTest extends DonkeyTestCase implements LazyFields, OverlaysWeb {
    //SIMIAN OFF
    ThrowableMaster chuckieMock;
    Throwable causeDummy;
    RuntimeException e;
    GarglerExceptionHandler subject;
    Nu nu;
    //SIMIAN ON

    public void overlay() {
        wire.ref(chuckieMock).to(ThrowableMaster.class);
    }

    public void test() {
        expect.manyCalls(chuckieMock, (Object) causeDummy, "realCause", e);
        expect.oneCall(chuckieMock, VOID, "rethrow", causeDummy);
        Tuple tuple = nu.nu(Tuple.class);
        subject.handle(tuple, e);
    }
}
