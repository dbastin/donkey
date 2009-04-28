package org.burroloco.butcher.fixture.checker.directory;

import java.io.File;

public interface DirPoller {
    File check(File dir);
}