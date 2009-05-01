package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.demo.http2jdbc.HttpToCsvSpecification;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.util.date.Dates;
import org.burroloco.util.string.TokenUtil;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestHandlerMolecularTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    private static final String EXPECTED = "data/expected/news.csv";
    private static final String OUT = "gen/demo/out/news.csv";
    private HttpRequestHandler subject;
    FileUtilsStatic fileUtils;
    TokenUtil tokenUtils;
    Dates datesMock;
    Date dateDummy;
    Impl impl;
    Nu nu;

    public void fixtures() {
        wire.ref(datesMock).to(Dates.class);
        HttpToCsvSpecification spec = impl.impl(HttpToCsvSpecification.class);
        Config config = spec.config();
        impl.impl(spec.wirer()).wire(config);
        subject = nu.nu(HttpRequestHandler.class, config);
    }

    public void testHttpSlurp() throws InterruptedException {
        expect.oneCall(datesMock, dateDummy, "now");
        subject.handle(new ControlServletRequest());
        check();
    }

    private void check() {
        String out = fileUtils.readFileToString(new File(OUT));
        String expected = fileUtils.readFileToString(new File(EXPECTED));
        Map<String, String> replacements = new HashMap<String, String>();
        replacements.put("NOW", dateDummy.toString());
        expected = tokenUtils.replace(expected, replacements);
        assertEquals(expected, out);
    }

}
