package org.burroloco.test.butcher.fixture.tibco;

import edge.java.io.OutputStream;
import org.burroloco.test.butcher.fixture.checker.stream.StreamChecker;
import org.burroloco.test.butcher.fixture.process.CommandController;

import java.io.File;

// FIX TSR-DONKEY DELETE ME
public class DefaultWireTap implements WireTap {
    private static final String LISTENER_STARTED = "tibrvlisten: Listening to subject >";
    private static final File WORKING = new File("src/sh/test");
    private Process process;
    CommandController control;
    StreamChecker checker;

    public void start(OutputStream o) {
        java.io.OutputStream out = outputStream(o);
        // FIX DONKEY Number, name. Tibco props instead??
        listen("6", "konst1", out);
        checker.check(o, LISTENER_STARTED);
    }

    public void stop() {
        control.destroy(process);
    }

    private java.io.OutputStream outputStream(OutputStream o) {
        return (java.io.OutputStream) o.unedge();
    }

    private void listen(String number, String host, java.io.OutputStream out) {
        // FIX TSR-DONKEY Move "listener" script to tsr?
        process = control.start(WORKING, out, out, "sh", "listener", number, host);
    }

}
