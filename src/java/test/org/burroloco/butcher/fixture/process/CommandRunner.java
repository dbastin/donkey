package org.burroloco.butcher.fixture.process;

import java.io.File;

public interface CommandRunner {
    int run(File workingDir, String... command);

    int run(String... command);
}
