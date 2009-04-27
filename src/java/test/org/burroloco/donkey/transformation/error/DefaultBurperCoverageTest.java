package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.OverlaysWeb;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class DefaultBurperCoverageTest extends DonkeyTestCase implements LazyFields, OverlaysWeb {
    ThrowableMaster chuckieMock;
    Throwable causeDummy;
    RuntimeException e;
    Burper subject;
    Nu nu;

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
