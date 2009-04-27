package org.burroloco.donkey.error;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.OverlaysWeb;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.listener.core.Puker;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class DefaultPukerCoverageTest extends DonkeyTestCase implements LazyFields, OverlaysWeb {
    ThrowableMaster chuckieMock;
    Throwable causeDummy;
    RuntimeException e;
    Config configDummy;
    Puker subject;
    Nu nu;

    public void overlay() {
        wire.ref(chuckieMock).to(ThrowableMaster.class);
    }

    public void test() {
        expect.oneCall(chuckieMock, (Object) causeDummy, "rootCause", e);
        expect.oneCall(chuckieMock, VOID, "rethrow", causeDummy);
        subject.error(configDummy, e);
    }
}
