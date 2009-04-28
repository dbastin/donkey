package org.burroloco.util.string;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.butcher.glue.testcase.ButcherTestCase;

public class DefaultStringUniqueAtomicTest extends ButcherTestCase {
    Nu nu;

    public void testAlwaysStamped() {
        StringUnique subject = nu.nu(StringUnique.class, true, 2, 4);
        String first = subject.unique("F");
        assertEquals("F01", first);
    }

    public void testTruncated() {
        StringUnique subject = nu.nu(StringUnique.class, true, 2, 6);
        String first = subject.unique("FRED SEEMS LIKE SUCH A SHORT NAME");
        assertEquals("FRED01", first);
    }

    public void testAlwaysStampedWithClash() {
        StringUnique subject = nu.nu(StringUnique.class, true, 2, 4);
        String first = subject.unique("FRED");
        String second = subject.unique("FRED SEEMS LIKE SUCH A SHORT NAME");
        assertEquals(4, second.length());
        assertNotEquals(first, second);
    }

    public void testStampOnlyOnClash() {
        StringUnique subject = nu.nu(StringUnique.class, false, 2, 4);
        String first = subject.unique("FRED");
        assertEquals("FRED", first);
        String second = subject.unique("FRED");
        assertNotEquals(first, second);
    }
}
