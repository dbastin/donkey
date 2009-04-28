package org.burroloco.butcher.fixture.checker.file;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.burroloco.butcher.util.poll.Poller;
import org.burroloco.butcher.util.poll.PollingBlock;

import java.io.File;

public class DefaultFileExistsPoller implements FileExistsPoller {
    private static final int TIMEOUT = 20;
    Poller poller;
    Impl impl;

    public boolean check(final File file) {
        PollingBlock exists = impl.impl(FileExistsPollingBlock.class, file);
        return poller.call(exists, TIMEOUT);
    }
}
