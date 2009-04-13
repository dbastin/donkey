package org.burroloco.donkey.trebuchet;

import org.burroloco.test.butcher.fixture.process.CommandController;
import org.burroloco.test.util.io.FileWirer;

public class DefaultAsyncDonkeyShell implements AsyncDonkeyShell {
    private Process process;
    CommandController controller;
    FileWirer file;

    public void run(String specification) {
        process = controller.start(file.basedir(), "sh", "donkey.sh", specification);
    }

    public void stop() {
        controller.destroy(process);
    }
}
