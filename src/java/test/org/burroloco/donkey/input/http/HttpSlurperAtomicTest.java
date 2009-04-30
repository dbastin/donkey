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

    public void testHttpSlurp() {
        Cake cake = subject.slurp(config());
        Slice slice = cake.slices().get(0);
        String msg = slice.value("Message").toString();
        Date date = (Date) slice.value("Date");
        assertEquals(MESSAGE, msg);
    }

    private Config config() {
        StrictMap config = new DefaultStrictMap();
        config.put(HttpRequest.NAME, MESSAGE);
        return nu.nu(Config.class, config);
    }
}
