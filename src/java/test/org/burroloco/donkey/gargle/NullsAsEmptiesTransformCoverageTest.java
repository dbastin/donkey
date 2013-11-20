package org.burroloco.donkey.gargle;

import au.net.netstorm.boost.gunge.collection.DefaultStrictMap;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.DefaultConfig;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import static org.burroloco.donkey.data.core.Null.NULL;

public class NullsAsEmptiesTransformCoverageTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    private static final Config EMPTY = new DefaultConfig(new DefaultStrictMap<String, String>());
    private static final String OTHER_FIELD = "OtherField";
    private static final String NULL_FIELD = "NullField";
    private TupleGargler subject;
    String value;
    Impl impl;
    Nu nu;

    public void fixtures() {
        wire.cls(NoOpTupleGargler.class).to(TupleGargler.class);
        subject = impl.impl(TupleGargler.class, NullsAsEmptiesTupleGargler.class);
    }

    public void testTransform() {
        Tuple actual = subject.gargle(EMPTY, slice());
        check(actual);
    }

    private Tuple slice() {
        Tuple in = nu.nu(Tuple.class);
        in.add(NULL_FIELD, NULL);
        in.add(OTHER_FIELD, value);
        return in;
    }

    private void check(Tuple actual) {
        assertEquals(2, actual.values().size());
        assertEquals("", actual.value(NULL_FIELD));
        assertEquals(value, actual.value(OTHER_FIELD));
    }
}
