package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.bullet.farmer.Push;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.farmer.SafePush;
import org.burroloco.donkey.farmer.SingleFilePush;
import org.burroloco.test.glue.testcase.TsrTestCase;

public class PushCoverageTest extends TsrTestCase implements LazyFields, HasFixtures {
    private SplittingPush splittingPush;
    private SingleFilePush singleFilePush;
    private SafePush safePush;
    RuntimeException exception;
    Config configDummy;
    Push pushDummy;
    Impl impl;

    public void fixtures() {
        wire.ref(pushDummy).to(Push.class);
        splittingPush = impl.impl(SplittingPush.class);
        singleFilePush = impl.impl(SingleFilePush.class, configDummy);
        safePush = impl.impl(SafePush.class);
    }

    public void testFail() {
        failNotImplmplemented(splittingPush);
        failNotImplmplemented(singleFilePush);
        failNotImplmplemented(safePush);
    }

    public void testStarting() {
        startingNotImplemented(splittingPush);
        startingNotImplemented(singleFilePush);
        startingNotImplemented(safePush);
    }

    private void startingNotImplemented(Push push) {
        try {
            push.starting();
            fail();
        } catch (UnsupportedOperationException e) {
        }
    }

    private void failNotImplmplemented(Push push) {
        try {
            push.fail(exception);
            fail();
        } catch (UnsupportedOperationException e) {
        }
    }
}
