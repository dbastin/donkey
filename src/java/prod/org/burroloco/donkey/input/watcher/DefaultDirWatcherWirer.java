package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.bullet.farmer.DefaultOperationManager;
import au.net.netstorm.boost.bullet.farmer.Farmer;
import au.net.netstorm.boost.bullet.farmer.Interval;
import au.net.netstorm.boost.bullet.farmer.Pull;
import au.net.netstorm.boost.bullet.farmer.Push;
import au.net.netstorm.boost.bullet.farmer.Timeout;
import au.net.netstorm.boost.gunge.lifecycle.StartStop;
import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.spider.api.runtime.Resolver;
import org.burroloco.config.core.Config;
import org.burroloco.config.wire.ConfigRegistrar;
import org.burroloco.donkey.config.InputDirName;
import org.burroloco.donkey.config.WatchInterval;
import org.burroloco.donkey.farmer.SafePush;
import org.burroloco.donkey.farmer.SingleFilePush;

public class DefaultDirWatcherWirer implements DirWatcherWirer {
    ConfigRegistrar registrar;
    Spinneret spinneret;
    Resolver resolver;
    Wire wire;
    Nu nu;

    public DirWatcher nu(Config config) {
        pull(config);
        push(config);
        interval(config);
        spinneret.spin(DirWatcherWeb.class);
        return watcher();
    }

    private void pull(Config config) {
        InputDirName dir = config.get(InputDirName.class);
        wire.impl(FilePuller.class, dir).to(Pull.class);
    }

    private void push(Config config) {
        wire.impl(SingleFilePush.class, config).to(Push.class, SafePush.class);
    }

    private void interval(Config config) {
        WatchInterval interval = config.get(WatchInterval.class);
        wire.ref(interval).to(Interval.class);
        wire.nu(Timeout.class, 0L).to(Timeout.class, DefaultOperationManager.class);
    }

    private DirWatcher watcher() {
        Farmer farmer = nu.nu(Farmer.class);
        Pull pull = nu.nu(Pull.class);
        Push push = nu.nu(Push.class);
        StartStop stop = farmer.farm(push, pull);
        wire.ref(stop).to(StartStop.class, DefaultDirWatcher.class);
        return resolver.resolve(DirWatcher.class);
    }
}
