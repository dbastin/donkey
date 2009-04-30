package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.OverlaysWeb;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.HttpMessage;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.transformation.gargler.Gargler;
import org.burroloco.util.date.Dates;

import java.util.Date;

public class HttpRequestHandlerMolecularTest extends DonkeyTestCase implements HasFixtures, LazyFields, OverlaysWeb {
    private static final String MESSAGE = "Hello World";
    private HttpRequestHandler subject;
    Gargler garglerMock;
    Config configDummy;
    Dates datesMock;
    Date dateDummy;
    Weaken weaken;
    Dates dates;
    Nu nu;

    public void overlay() {
    }

    public void fixtures() {
        wire.ref(datesMock).to(Dates.class);
        wire.ref(garglerMock).to(Gargler.class);
        subject = nu.nu(HttpRequestHandler.class, configDummy);
    }

    public void testHttpSlurp() throws InterruptedException {
        expect.oneCall(datesMock, dateDummy, "now");
        expect.oneCall(garglerMock, VOID, "slosh", configDummy, cake());
        subject.handleRequest(MESSAGE);
    }

    private Cake cake() {
        Cake out = nu.nu(Cake.class);
        out.add(slice(nu.nu(HttpMessage.class, MESSAGE)));
        return out;
    }

    private Slice slice(HttpMessage message) {
        Slice slice = nu.nu(Slice.class);
        slice.add("Message", weaken.w(message));
        slice.add("Date", dateDummy);
        return slice;
    }
}