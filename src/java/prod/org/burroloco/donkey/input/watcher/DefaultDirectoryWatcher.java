package org.burroloco.donkey.input.watcher;

import au.net.netstorm.boost.gunge.goop.Nvp;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.Configs;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.InputDirName;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.config.WatchInterval;
import org.burroloco.donkey.loop.Loop;
import org.burroloco.donkey.loop.SingleLoop;
import org.burroloco.util.snooze.Snoozer;

import java.io.File;
import java.util.List;

public class DefaultDirectoryWatcher implements DirectoryWatcher {

    private boolean started = false;
    Configs configs;
    FileListing listing;
    WeakConfig weak;
    Snoozer snoozer;
    Impl impl;
    Nu nu;

    public void start(Config config) {
        started = true;
        File dir = dir(config);
        Long interval = interval(config);
        while (started) {
            List<File> files = listing.list(dir);
            for (File file : files) process(config, file);
            snoozer.snooze(interval);
        }
    }

    public void stop() {
        started = false;
    }

    private void process(Config config, File file) {
        Nvp entry = nu.nu(Nvp.class, InputFileName.NAME, file.getPath());
        Config c = configs.add(config, entry);
        Loop loop = impl.impl(SingleLoop.class);
        loop.go(c);
    }

    private File dir(Config config) {
        String name = weak.get(config, InputDirName.class);
        return new File(name);
    }

    private Long interval(Config config) {
        return weak.get(config, WatchInterval.class);
    }
}

