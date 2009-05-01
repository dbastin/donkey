package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.butcher.util.file.FileComparator;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.demo.http2jdbc.HttpToCsvSpecification;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;

import java.io.File;

public class HttpRequestHandlerMolecularTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    private static final File EXPECTED = new File("data/expected/news.csv");
    private static final File ACTUAL = new File("gen/demo/out/news.csv");
    private HttpRequestHandler subject;
    FileComparator comparator;
    Impl impl;
    Nu nu;

    public void fixtures() {
        HttpToCsvSpecification spec = impl.impl(HttpToCsvSpecification.class);
        Config config = spec.config();
        impl.impl(spec.wirer()).wire(config);
        subject = nu.nu(HttpRequestHandler.class, config);
    }

    public void testHttpSlurp() throws InterruptedException {
        subject.handle(new ControlServletRequest());
        comparator.assertEquals(EXPECTED, ACTUAL);
    }
}
