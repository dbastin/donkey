package org.burroloco.tibco.transport;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.com.tibco.tibrv.TibrvMsg;
import edge.java.io.ByteArrayOutputStream;
import org.burroloco.test.butcher.fixture.checker.file.PollingFileChecker;
import org.burroloco.test.butcher.fixture.checker.stream.StreamChecker;
import org.burroloco.test.butcher.fixture.tibco.WireTap;
import org.burroloco.test.constants.TestConstants;
import org.burroloco.test.glue.testcase.TsrTestCase;
import org.burroloco.test.util.io.FileWirer;
import org.burroloco.tibco.config.TestTibcoWirer;
import org.burroloco.tibco.factory.LifecycleTibcoFactory;

public class TransportMolecularTest extends TsrTestCase implements HasFixtures, LazyFields, Destroyable, TestConstants {
    private LifecycleTibcoFactory tibco;
    private TibcoTransport subject;
    PollingFileChecker filePoller;
    StreamChecker streamChecker;
    ByteArrayOutputStream out;
    TestTibcoWirer tibcoWirer;
    String tibcoSubject;
    TibrvMsg message;
    String payload;
    FileWirer file;
    WireTap tap;
    Nu nu;

    public void fixtures() {
        tibcoWirer.wire();
        tibco = nu.nu(LifecycleTibcoFactory.class);
        subject = tibco.transport();
        tap.start(out);
    }

    public void testSend() {
        sendMessage();
        checkMessage();
    }

    public void destroy() {
        tap.stop();
        tibco.destroy();
    }

    private void sendMessage() {
        message.setSendSubject(tibcoSubject);
        message.add(payload, tibcoSubject);
        subject.send(message);
    }

    private void checkMessage() {
        streamChecker.check(out, "subject=" + tibcoSubject);
        filePoller.check(file.file(LOG), "Sending to .*: \\{ " + payload + "=\"" + tibcoSubject + "\"");
    }
}
