package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.bullet.log.Log;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.test.glue.testcase.TsrTestCase;

public class DefaultPukerAtomicTest extends TsrTestCase implements LazyFields, HasFixtures {
    private Puker subject;
    Slice slice;
    Log logMock;
    Nu nu;

    public void fixtures() {
        wire.ref(logMock).to(Log.class, DefaultPuker.class);
        subject = nu.nu(Puker.class);
    }

    public void testDefaultExceptionHandling() {
        TransformException ex = exception();
        expect.oneCall(logMock, VOID, "error", "This slice is awful: " + slice, ex);
        try {
            subject.puke(slice, ex);
            fail("Should barf");
        } catch (TransformException e) {
        }
    }

    private TransformException exception() {
        return new TransformException(slice, "random");
    }
}
