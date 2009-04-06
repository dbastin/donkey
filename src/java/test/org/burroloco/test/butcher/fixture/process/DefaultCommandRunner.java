package org.burroloco.test.butcher.fixture.process;

import java.io.File;

public class DefaultCommandRunner implements CommandRunner {
    CommandController controller;

    public int run(File workingDir, String... command) {
        return waitFor(workingDir, command);
    }

    public int run(String... command) {
        return waitFor(null, command);
    }

    private int waitFor(File workingDir, String... command) {
        Process proc = null;
        try {
            proc = controller.start(workingDir, command);
            return proc.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            controller.destroy(proc);
        }
    }

}
