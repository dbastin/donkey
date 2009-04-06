package org.burroloco.test.butcher.fixture.process;

import java.io.File;

public interface CommandRunner {
    int run(File workingDir, String... command);

    int run(String... command);
}
