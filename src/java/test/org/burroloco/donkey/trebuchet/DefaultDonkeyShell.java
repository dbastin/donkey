package org.burroloco.donkey.trebuchet;

import org.burroloco.butcher.fixture.process.CommandRunner;
import static org.burroloco.donkey.glue.constants.TestConstants.DIST;
import static org.junit.Assert.assertEquals;

public class DefaultDonkeyShell implements DonkeyShell {
    CommandRunner runner;

    public void run(String specification) {
        int result = runner.run(DIST, "sh", "donkey.sh", specification);
        assertEquals("donkey.sh return code", 0, result);
    }
}
