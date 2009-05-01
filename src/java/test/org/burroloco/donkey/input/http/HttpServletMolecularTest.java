package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.demo.http2jdbc.HttpToJdbcSpecification;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.util.date.Dates;

import java.util.Date;

public class HttpServletMolecularTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    private static final String MESSAGE = "Hello World";
    private TrapDoor subject;
    ConfigLoader loader;
    Dates datesMock;
    Date dateDummy;
    Impl impl;
    Nu nu;

    public void fixtures() {
        wire.ref(datesMock).to(Dates.class);
        HttpToJdbcSpecification spec = impl.impl(HttpToJdbcSpecification.class);
        Config config = spec.config();
        impl.impl(spec.wirer()).wire(config);
        subject = nu.nu(TrapDoor.class, config);
    }

    public void testHttpSlurp() throws InterruptedException {
        expect.oneCall(datesMock, dateDummy, "now");
        subject.handleRequest(new ControlServletRequest());
        // Compare CSVs
    }

}
