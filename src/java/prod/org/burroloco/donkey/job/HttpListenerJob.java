package org.burroloco.donkey.job;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.winstone.Launcher;
import edge.winstone.LauncherStatic;
import org.burroloco.config.core.Config;

import java.util.Map;

public class HttpListenerJob implements Job {
    LauncherStatic launcherStatic;
    Map args;
    Nu nu;

    // FIX DONKEY WIP. Please leave.
    public void go(Config config) {
        args.put("webroot", "donkey");
        args.put("httpPort", "8282");
        launcherStatic.initLogger(args);
        nu.nu(Launcher.class, args);
    }
}
