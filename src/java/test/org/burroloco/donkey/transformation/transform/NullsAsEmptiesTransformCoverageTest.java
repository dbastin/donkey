package org.burroloco.donkey.transformation.transform;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.input.database.DatabaseNull;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class NullsAsEmptiesTransformCoverageTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    private static final String OTHER_FIELD = "OtherField";
    private static final String NULL_FIELD = "NullField";
    private NullsAsEmptiesTransform subject;
    String value;
    Impl impl;
    Nu nu;

    public void fixtures() {
        wire.cls(NoOpTransform.class).to(Transform.class);
        subject = impl.impl(NullsAsEmptiesTransform.class);
    }

    public void testTransform() {
        Slice actual = subject.transform(slice());
        check(actual);
    }

    private Slice slice() {
        Slice in = nu.nu(Slice.class);
        in.add(NULL_FIELD, new DatabaseNull());
        in.add(OTHER_FIELD, value);
        return in;
    }

    private void check(Slice actual) {
        assertEquals(2, actual.values().size());
        assertEquals("", actual.value(NULL_FIELD));
        assertEquals(value, actual.value(OTHER_FIELD));
    }
}
