package org.burroloco.donkey.demo.http2jdbc;

import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.util.snooze.Snoozer;

public class HttpToJdbcDemoTest extends DonkeyTestCase {
    Trebuchet trebuchet;
    Snoozer snoozer;

    // FIX DONKEY WIP Please leave... 
    public void testHttpToJdbc() {
        trebuchet.launch(HttpToJdbcSpecification.class);
        snoozer.snooze(2000);
    }
}
