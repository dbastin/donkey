package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.javax.servlet.http.HttpServletRequest;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.transformation.gargler.Gargler;
import org.burroloco.util.date.Dates;

import java.util.Date;

public class HttpServletMolecularTest extends DonkeyTestCase implements HasFixtures, LazyFields {
    private static final String MESSAGE = "Hello World";
    private HttpServlet subject;
    HttpServletRequest requestMock;
    Gargler garglerMock;
    Config configDummy;
    Dates datesMock;
    Date dateDummy;
    Nu nu;

    public void fixtures() {
        wire.ref(datesMock).to(Dates.class);
        wire.ref(garglerMock).to(Gargler.class);
        subject = nu.nu(HttpServlet.class, configDummy);
    }

    public void testHttpSlurp() throws InterruptedException {
        expect.oneCall(datesMock, dateDummy, "now");
        expect.oneCall(garglerMock, VOID, "slosh", configDummy, expectedCake());
        subject.handleRequest(new ControlServletRequest());
    }

    private Cake expectedCake() {
        Cake out = nu.nu(Cake.class);
        Slice slice = nu.nu(Slice.class);
        slice.add("Message", MESSAGE);
        slice.add("Date", dateDummy);
        out.add(slice);
        return out;
    }

}