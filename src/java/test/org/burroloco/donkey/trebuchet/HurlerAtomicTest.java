package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.test.glue.testcase.TsrTestCase;

public class HurlerAtomicTest extends TsrTestCase implements LazyFields, HasFixtures {
    private SpideredMain subject;
    Trebuchet trebuchetMock;
    Impl impl;

    public void fixtures() {
        wire.ref(trebuchetMock).to(Trebuchet.class);
        subject =impl.impl(SpideredMain.class);
    }

    public void testSuccesfulTaster() {
        expect.oneCall(trebuchetMock, VOID, "launch", DummyPayload.class);
        execute(DummyPayload.class.getName());
    }

    public void testSuccesfulWatch() {
        expect.oneCall(trebuchetMock, VOID, "launch", DummyPayload.class);
        execute(DummyPayload.class.getName());
    }

    public void testWrongNumberOfArgs() {
        try {
            execute("unwanted donkey", DummyPayload.class.getName());
            fail("NOT FAILED!");
        } catch (IllegalArgumentException e) {
            // Expected.
        }
    }

    private void execute(String... args) {
        subject.go(args);
    }
}
