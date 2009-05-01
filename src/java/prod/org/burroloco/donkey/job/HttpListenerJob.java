package org.burroloco.donkey.job;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.mortbay.jetty.Server;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.HttpPort;
import org.burroloco.donkey.input.http.JettyRequestHandler;
import org.mortbay.jetty.handler.AbstractHandler;

public class HttpListenerJob implements Job {
    WeakConfig weak;
    Impl impl;
    Nu nu;

    public void go(Config config) {
        Server server = server(config);
        handler(config, server);
        server.start();
    }

    private Server server(Config config) {
        Integer port = weak.get(config, HttpPort.class);
        return nu.nu(Server.class, port);
    }

    private void handler(Config config, Server server) {
        AbstractHandler handler = impl.impl(JettyRequestHandler.class, config);
        server.setHandler(handler);
    }
}
