package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

public class ColumnCopierCoverageTest extends DonkeyTestCase implements LazyFields, InjectableSubject {
    private ColumnCopier subject = new DefaultColumnCopier();
    Nu nu;

    public void testHandleNoRejects() {
        Slice in = nu.nu(Slice.class);
        Slice out = nu.nu(Slice.class);
        in.add("one", 1);
        in.add("two", 2);
        subject.copy(in, out, "one", "two");
        assertEquals(1, out.value("one"));
        assertEquals(2, out.value("two"));
    }
}
