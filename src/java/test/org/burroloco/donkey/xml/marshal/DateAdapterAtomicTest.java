package org.burroloco.donkey.xml.marshal;

import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import java.util.Date;

import static org.burroloco.butcher.util.date.StringDater.date;

public class DateAdapterAtomicTest extends DonkeyTestCase {

    // OK IllegalRegexp {
    private DateAdapter subject = new DateAdapter();
    // }

    public void testUnmarshal() throws Exception {
        Date date = subject.unmarshal("2001-01-01");
        checkDate(date);
    }

    private void checkDate(Date actual) {
        Date expected = date("2001-01-01");
        assertEquals(expected, actual);
    }
}
