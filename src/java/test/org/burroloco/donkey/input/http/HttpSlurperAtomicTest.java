package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.sniper.marker.LazyFields;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

public class HttpSlurperAtomicTest extends DonkeyTestCase implements LazyFields {
    HttpSlurper subject;
    Config configDummy;

    public void testHttpSlurp() {
        try {
            subject.slurp(configDummy);
            fail();
        } catch (Exception e) {
            // ignore
        }
    }
}
