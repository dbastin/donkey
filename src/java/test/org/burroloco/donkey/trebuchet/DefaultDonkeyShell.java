package org.burroloco.donkey.trebuchet;

import org.burroloco.test.butcher.fixture.process.CommandRunner;
import org.burroloco.test.util.io.FileWirer;
import static org.junit.Assert.assertEquals;

public class DefaultDonkeyShell implements DonkeyShell {
    CommandRunner runner;
    FileWirer file;

    public void run(String payload) {
        int result = runner.run(file.basedir(), "sh", "donkey.sh", payload);
        assertEquals("donkey.sh return code", 0, result);
    }
}
