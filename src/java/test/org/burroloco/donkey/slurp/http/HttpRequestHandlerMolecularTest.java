package org.burroloco.donkey.slurp.http;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.butcher.util.file.FileComparator;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.demo.http2csv.HttpToCsvSpecification;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.trebuchet.Wirer;

import java.io.File;

public class HttpRequestHandlerMolecularTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    private static final File EXPECTED = new File("data/expected/news.csv");
    private static final File ACTUAL = new File("gen/demo/out/news.csv");
    private HttpRequestHandler subject;
    FileComparator comparator;
    Impl impl;
    Nu nu;

    public void fixtures() {
        HttpToCsvSpecification spec = impl.impl(HttpToCsvSpecification.class, HttpToCsvSpecification.class);
        Config config = spec.config();
        impl.impl(Wirer.class, spec.wirer()).wire(config);
        subject = nu.nu(HttpRequestHandler.class, config);
    }

    public void testHttpSlurp() throws InterruptedException {
        subject.handle(new ControlServletRequest());
        comparator.assertEquals(EXPECTED, ACTUAL);
    }
}
