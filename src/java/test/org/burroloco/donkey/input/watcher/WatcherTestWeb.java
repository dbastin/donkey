package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;

public class WatcherTestWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(AsyncDirectoryWatcher.class).one().to(DirectoryWatcher.class);
        wire.cls(DefaultDirectoryWatcher.class).one().to(DirectoryWatcher.class, AsyncDirectoryWatcher.class);
    }
}
