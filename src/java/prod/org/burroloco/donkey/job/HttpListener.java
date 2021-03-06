package org.burroloco.donkey.job;

import au.net.netstorm.boost.gunge.lifecycle.Stop;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.eclipse.jetty.server.Server;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.HttpPort;
import org.burroloco.donkey.slurp.http.EdgeHttpRequestHandler;
import org.eclipse.jetty.server.Handler;

public class HttpListener implements Job, Stop {
    private Server server;
    WeakConfig weak;
    Impl impl;
    Nu nu;

    public void go(Config config) {
        server = server(config);
        setHandler(config);
        server.start();
        server.join();
    }

    public void stop() {
        server.stop();
    }

    private Server server(Config config) {
        Integer port = weak.get(config, HttpPort.class);
        return nu.nu(Server.class, port);
    }

    private void setHandler(Config config) {
        Handler handler = impl.impl(Handler.class, EdgeHttpRequestHandler.class, config);
        server.setHandler(handler);
    }
}
