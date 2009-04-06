package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.bullet.farmer.Push;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.test.glue.testcase.TsrTestCase;

import java.util.Arrays;

public class SplittingPushAtomicTest extends TsrTestCase implements HasFixtures, LazyFields {
    private Push subject;
    Push pushMock;
    Long[] list;
    Impl impl;

    public void fixtures() {
        wire.ref(pushMock).to(Push.class);
        subject = impl.impl(SplittingPush.class);
    }

    public void testIterables() {
        Iterable items = Arrays.asList(list);
        setUpExpectations(items);
        subject.push(items);
    }

    private void setUpExpectations(Iterable items) {
        for (Object item : items) {
            expect.oneCall(pushMock, VOID, "push", item);
        }
    }
}
