package org.burroloco.butcher.fixture.checker.directory;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.butcher.util.poll.Poller;
import org.burroloco.butcher.util.poll.PollingBlock;

import java.io.File;

public class DefaultDirPoller implements DirPoller {
    private static final int TIMEOUT = 30;
    Poller poller;
    Impl impl;

    public File check(final File dir) {
        PollingBlock exists = impl.impl(PollingBlock.class, DirectoryPollingBlock.class, dir);
        if (poller.call(exists, TIMEOUT)) return dir.listFiles()[0];
        else throw new RuntimeException(
                "No files found in " + dir.getAbsolutePath() + " within " + TIMEOUT + " seconds.");
    }

}
