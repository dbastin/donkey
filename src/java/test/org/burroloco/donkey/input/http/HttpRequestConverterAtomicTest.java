package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.config.HttpMessage;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.util.date.Dates;

import java.util.Date;

public class HttpRequestConverterAtomicTest extends DonkeyTestCase {
    private static final String MESSAGE = "Hello World";
    HttpRequestConverter subject;
    Dates dates;
    Nu nu;

    public void testHttpSlurp() throws InterruptedException {
        Cake cake = subject.convert(nu.nu(HttpMessage.class, MESSAGE));
        check(cake.slices().get(0));
    }

    private void check(Slice slice) {
        assertEquals(MESSAGE, slice.value("Message").toString());
        checkDateInLast5Seconds((Date) slice.value("Date"));
    }

    private void checkDateInLast5Seconds(Date date) {
        Date now = dates.now();
        long diff = now.getTime() - date.getTime();
        assertEquals(true, diff < 5000);
        assertEquals(true, diff >= 0);
    }
}
