package org.burroloco.donkey.farmer;

import au.net.netstorm.boost.bullet.farmer.Push;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.OverlaysWeb;
import org.burroloco.test.glue.testcase.TsrTestCase;

public class SafePushAtomicTest extends TsrTestCase implements LazyFields, OverlaysWeb {
    Push pushMock;
    Push subject;

    public void overlay() {
        wire.cls(SafePush.class).to(Push.class);
        wire.ref(pushMock).to(Push.class, SafePush.class);
    }

    public void test() {
        Object foo = new Object();
        expect.oneCall(pushMock, new RuntimeException(""), "push", foo);
        subject.push(foo);
    }
}
