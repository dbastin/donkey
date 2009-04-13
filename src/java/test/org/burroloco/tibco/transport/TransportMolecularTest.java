package org.burroloco.tibco.transport;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.com.tibco.tibrv.TibrvMsg;
import edge.com.tibco.tibrv.TibrvRvdTransport;
import org.burroloco.test.butcher.fixture.checker.file.PollingFileChecker;
import org.burroloco.test.butcher.fixture.checker.stream.StreamChecker;
import org.burroloco.test.constants.TestConstants;
import org.burroloco.test.glue.testcase.DonkeyTestCase;
import org.burroloco.test.util.io.FileWirer;
import org.burroloco.tibco.config.TestTibcoWirer;
import org.burroloco.tibco.factory.LifecycleTibcoFactory;

public class TransportMolecularTest extends DonkeyTestCase implements HasFixtures, LazyFields, Destroyable, TestConstants {
    private LifecycleTibcoFactory tibco;
    private TibcoTransport subject;
    PollingFileChecker filePoller;
    StreamChecker streamChecker;
    TestTibcoWirer tibcoWirer;
    String tibcoSubject;
    TibrvMsg message;
    String payload;
    FileWirer file;
    Nu nu;

    public void fixtures() {
        wire.cls(DefaultTestTibrvRvdTransport.class).to(TibrvRvdTransport.class);
        tibcoWirer.wire();
        tibco = nu.nu(LifecycleTibcoFactory.class);
        subject = tibco.transport();
    }

    public void testSend() {
        sendMessage();
    }

    public void destroy() {
        tibco.destroy();
    }

    private void sendMessage() {
        message.setSendSubject(tibcoSubject);
        message.add(payload, tibcoSubject);
        subject.send(message);
        TibrvMsg actual = ((TestTibrvRvdTransport) subject.tibby()).get();
        assertEquals(message.toString(), actual.toString());
    }
}
