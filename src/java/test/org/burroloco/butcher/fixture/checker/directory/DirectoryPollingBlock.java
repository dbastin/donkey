package org.burroloco.butcher.fixture.checker.directory;

import org.burroloco.butcher.util.poll.PollingBlock;

import java.io.File;

public class DirectoryPollingBlock implements PollingBlock {
    private final File dir;

    public DirectoryPollingBlock(File dir) {
        this.dir = dir;
    }

    public boolean call() {
        return dir.exists() && dir.list().length > 0;
    }
}