package org.burroloco.donkey.trebuchet;

import org.burroloco.test.butcher.fixture.process.CommandController;
import static org.burroloco.test.constants.TestConstants.DIST;

public class DefaultAsyncDonkeyShell implements AsyncDonkeyShell {
    private Process process;
    CommandController controller;

    public void run(String specification) {
        process = controller.start(DIST, "sh", "donkey.sh", specification);
    }

    public void stop() {
        controller.destroy(process);
    }
}
