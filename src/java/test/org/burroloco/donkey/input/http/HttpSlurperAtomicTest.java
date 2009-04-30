package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.gunge.collection.DefaultStrictMap;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.HttpRequest;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import java.util.Date;

public class HttpSlurperAtomicTest extends DonkeyTestCase implements LazyFields {
    private static final String MESSAGE = "Hello World";
    HttpSlurper subject;
    Nu nu;

    public void testHttpSlurp() throws InterruptedException {
        Cake cake = subject.slurp(config());
        check(cake.slices().get(0));
    }

    private Config config() {
        StrictMap config = new DefaultStrictMap();
        config.put(HttpRequest.NAME, MESSAGE);
        return nu.nu(Config.class, config);
    }

    private void check(Slice slice) {
        assertEquals(MESSAGE, slice.value("Message").toString());
        checkDateInLast5Seconds((Date) slice.value("Date"));
    }

    private void checkDateInLast5Seconds(Date date) {
        // OK IllegalRegexp {
        Date now = new Date();
        // }
        long diff = now.getTime() - date.getTime();
        assertEquals(true, diff < 5000);
        assertEquals(true, diff >= 0);
    }
}
