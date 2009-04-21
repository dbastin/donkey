package org.burroloco.demo.tibco2fixed;

import au.net.netstorm.boost.gunge.lifecycle.Stop;
import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import com.tibco.tibrv.Tibrv;
import edge.com.tibco.tibrv.TibrvStatic;
import org.burroloco.donkey.trebuchet.TestTrebuchet;
import org.burroloco.test.butcher.fixture.tibco.Publisher;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.test.util.io.FileComparator;
import org.burroloco.util.snooze.Snoozer;

import java.io.File;
import java.util.Map;

public class TibcoToFixedWidthDemoTest extends DonkeyTestCase implements Destroyable, HasFixtures {
    private static final File EXPECTED = new File("data/expected/employee.fixed");
    private static final File ACTUAL = new File("gen/test/out/employee.fixed");
    Map<String, Object> payload;
    FileComparator comparator;
    TestTrebuchet trebuchet;
    TibrvStatic tibrv;
    Snoozer snoozer;
    Nu nu;

    public void fixtures() {
        payload.put("ID", "1");
        payload.put("NAME", "Fred");
    }

    public void testTibcoToFixedWidth() {
        Class<? extends Web> testWiring = TibcoToFixedWidthTestWeb.class;
        trebuchet.launch(TibcoToFixedWidthSpecification.class, testWiring);
        send();
        snoozer.snooze(2000);
    }

    public void destroy() {
        Stop job = spider.resolve(Stop.class);
        job.stop();
    }

    private void send() {
        tibrv.open(Tibrv.IMPL_NATIVE);
        Publisher publisher = nu.nu(Publisher.class);
        publisher.send("test", payload);
    }
}