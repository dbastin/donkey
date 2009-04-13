package org.burroloco.donkey.trebuchet;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class HurlerAtomicTest extends DonkeyTestCase implements LazyFields, HasFixtures {
    private SpideredMain subject;
    Trebuchet trebuchetMock;
    Impl impl;

    public void fixtures() {
        wire.ref(trebuchetMock).to(Trebuchet.class);
        subject =impl.impl(SpideredMain.class);
    }

    public void testSuccesfulTaster() {
        expect.oneCall(trebuchetMock, VOID, "launch", DummySpecification.class);
        execute(DummySpecification.class.getName());
    }

    public void testSuccesfulWatch() {
        expect.oneCall(trebuchetMock, VOID, "launch", DummySpecification.class);
        execute(DummySpecification.class.getName());
    }

    public void testWrongNumberOfArgs() {
        try {
            execute("unwanted donkey", DummySpecification.class.getName());
            fail("NOT FAILED!");
        } catch (IllegalArgumentException e) {
            // Expected.
        }
    }

    private void execute(String... args) {
        subject.go(args);
    }
}
