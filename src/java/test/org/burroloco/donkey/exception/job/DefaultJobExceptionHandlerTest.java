package org.burroloco.donkey.exception.job;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.OverlaysWeb;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class DefaultJobExceptionHandlerTest extends DonkeyTestCase implements LazyFields, OverlaysWeb {
    ThrowableMaster chuckieMock;
    JobExceptionHandler subject;
    Throwable causeDummy;
    RuntimeException e;
    Config configDummy;

    public void overlay() {
        wire.ref(chuckieMock).to(ThrowableMaster.class);
    }

    //SIMIAN OFF
    public void test() {
        expect.manyCalls(chuckieMock, causeDummy, "realCause", e);
        expect.oneCall(chuckieMock, VOID, "rethrow", causeDummy);
        subject.error(configDummy, e);
    }
    //SIMIAN ON
}
