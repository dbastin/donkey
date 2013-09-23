package org.burroloco.donkey.transformation.transform;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.input.database.DatabaseNull;
import org.burroloco.donkey.transform.NoOpTupleGargler;
import org.burroloco.donkey.transform.NullsAsEmptiesTupleGargler;
import org.burroloco.donkey.transform.TupleGargler;

public class NullsAsEmptiesTransformCoverageTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    private static final String OTHER_FIELD = "OtherField";
    private static final String NULL_FIELD = "NullField";
    private NullsAsEmptiesTupleGargler subject;
    String value;
    Impl impl;
    Nu nu;

    public void fixtures() {
        wire.cls(NoOpTupleGargler.class).to(TupleGargler.class);
        subject = impl.impl(NullsAsEmptiesTupleGargler.class);
    }

    public void testTransform() {
        Tuple actual = subject.gargle(slice());
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
