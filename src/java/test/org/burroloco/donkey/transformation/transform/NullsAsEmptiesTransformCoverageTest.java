package org.burroloco.donkey.transformation.transform;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.input.database.DatabaseNull;

public class NullsAsEmptiesTransformCoverageTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    private static final String OTHER_FIELD = "OtherField";
    private static final String NULL_FIELD = "NullField";
    private NullsAsEmptiesTupleTransformer subject;
    String value;
    Impl impl;
    Nu nu;

    public void fixtures() {
        wire.cls(NoOpTupleTransformer.class).to(TupleTransformer.class);
        subject = impl.impl(NullsAsEmptiesTupleTransformer.class);
    }

    public void testTransform() {
        Tuple actual = subject.transform(slice());
        check(actual);
    }

    private Tuple slice() {
        Tuple in = nu.nu(Tuple.class);
        in.add(NULL_FIELD, new DatabaseNull());
        in.add(OTHER_FIELD, value);
        return in;
    }

    private void check(Tuple actual) {
        assertEquals(2, actual.values().size());
        assertEquals("", actual.value(NULL_FIELD));
        assertEquals(value, actual.value(OTHER_FIELD));
    }
}
