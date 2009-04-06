package org.burroloco.test.butcher.fixture.checker.file;

import org.burroloco.test.util.poll.PollingBlock;

import java.io.File;

public class FileExistsPollingBlock implements PollingBlock {
    private final File file;

    public FileExistsPollingBlock(File file) {
        this.file = file;
    }

    public boolean call() {
        return file.exists();
    }
}
