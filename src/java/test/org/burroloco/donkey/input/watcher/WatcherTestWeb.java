package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;

public class WatcherTestWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(AsyncDirWatcher.class).one().to(DirWatcher.class);
        wire.cls(DefaultDirWatcher.class).one().to(DirWatcher.class, AsyncDirWatcher.class);
    }
}
