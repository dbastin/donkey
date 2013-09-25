package org.burroloco.donkey.xml.marshal;

import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import java.util.Date;

public class DateAdapterAtomicTest extends DonkeyTestCase {

    // OK IllegalRegexp {
    private DateAdapter subject = new DateAdapter();
    // }

    public void testUnmarshal() throws Exception {
        Date date = subject.unmarshal("2001-01-01");
        long time = date.getTime();
        assertEquals(978267600000L, time);
    }
}
