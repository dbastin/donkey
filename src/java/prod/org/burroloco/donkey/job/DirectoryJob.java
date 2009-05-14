package org.burroloco.donkey.job;

import au.net.netstorm.boost.gunge.goop.Nvp;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.Configs;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.InputDirName;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.input.file.FileListing;
import org.burroloco.util.snooze.Snoozer;

import java.io.File;
import java.util.List;

public class DirectoryJob implements Job {
    FileListing listing;
    Configs configs;
    WeakConfig weak;
    Snoozer snoozer;
    Job delegate;
    Nu nu;

    public void go(Config config) {
        File dir = dir(config);
        List<File> files = listing.list(dir);
        quietTime();
        for (File file : files) process(config, file);
    }

    private void quietTime() {
        snoozer.snooze(1000);
    }

    private void process(Config config, File file) {
        Nvp entry = nu.nu(Nvp.class, InputFileName.NAME, file.getPath());
        Config c = configs.moosh(config, entry);
        delegate.go(c);
    }

    private File dir(Config config) {
        String name = weak.get(config, InputDirName.class);
        return new File(name);
    }
}