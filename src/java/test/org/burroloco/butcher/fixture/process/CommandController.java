package org.burroloco.butcher.fixture.process;

import java.io.File;
import java.io.OutputStream;

public interface CommandController {
    Process start(File workingDir, String... command);

    Process start(File workingDir, OutputStream out, OutputStream err, String... command);

    void destroy(Process process);
}
