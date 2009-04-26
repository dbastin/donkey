package org.burroloco.donkey.transformation.error;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class TransformErrorHandlerAtomicTest extends DonkeyTestCase implements LazyFields, HasFixtures {
    private TransformErrorHandler subject;
    Slice slice;
    Nu nu;

    public void fixtures() {
        subject = nu.nu(TransformErrorHandler.class);
    }

    public void testDefaultExceptionHandling() {
        TransformException ex = exception();
        try {
            subject.error(slice, ex);
            fail("Should barf");
        } catch (TransformException e) {
        }
    }

    private TransformException exception() {
        return new TransformException(slice, "random");
    }
}
