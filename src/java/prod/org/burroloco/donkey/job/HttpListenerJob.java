package org.burroloco.donkey.job;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.winstone.Launcher;
import edge.winstone.LauncherStatic;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.HttpPort;
import org.burroloco.donkey.config.WebRoot;

import java.util.Map;

public class HttpListenerJob implements Job {
    LauncherStatic launcherStatic;
    WeakConfig weak;
    Map args;
    Nu nu;

    // FIX DONKEY WIP. Please leave.
    public void go(Config config) {
        args(config);
        launcherStatic.initLogger(args);
        nu.nu(Launcher.class, args);
    }

    private void args(Config config) {
        args.put("webroot", weak.get(config, WebRoot.class));
        args.put("httpPort", weak.get(config, HttpPort.class));
    }
}
