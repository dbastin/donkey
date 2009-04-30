package org.burroloco.donkey.job;

import au.net.netstorm.boost.gunge.lifecycle.Stop;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.winstone.LauncherStatic;
import org.burroloco.config.core.Config;
import edge.winstone.Launcher;

import java.util.Map;

public class HttpListenerJob implements Job, Stop {
    private Launcher winstone;
    LauncherStatic launcherStatic;
    Map args;
    Nu nu;

    public void go(Config config) {
        args.put("webroot", "donkey");
        launcherStatic.initLogger(args);
        winstone = nu.nu(Launcher.class, args);
    }

    public void stop() {
        winstone.shutdown();
    }
}
