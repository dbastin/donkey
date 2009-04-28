package org.burroloco.donkey.error.transform;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.OverlaysWeb;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.test.glue.testcase.DonkeyTestCase;

public class DefaultBurperCoverageTest extends DonkeyTestCase implements LazyFields, OverlaysWeb {
    //SIMIAN OFF
    ThrowableMaster chuckieMock;
    Throwable causeDummy;
    RuntimeException e;
    Burper subject;
    Nu nu;
    //SIMIAN ON

    public void overlay() {
        wire.ref(chuckieMock).to(ThrowableMaster.class);
    }

    public void test() {
        expect.oneCall(chuckieMock, (Object) causeDummy, "realCause", e);
        expect.oneCall(chuckieMock, VOID, "rethrow", causeDummy);
        Slice slice = nu.nu(Slice.class);
        subject.error(slice, e);
    }
}
