package org.burroloco.butcher.fixture.http;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.ssl.SslSocketConnector;
import org.eclipse.jetty.util.ssl.SslContextFactory;

import java.util.List;

public class DefaultTargetHttpServer implements TargetHttpServer {

    private StringHandler handler;
    private Server s;

    Impl impl;
    Nu nu;

    public void start() {
        s = nu.nu(Server.class, 8030);
        handler = impl.impl(StringHandler.class, StringHandler.class);
        s.setHandler(handler);
        s.addConnector(sslConnector(8443));
        s.start();
    }

    public List<String> requests() {
        return handler.getRequests();
    }

    public void stop() {
        s.stop();
    }

    private Connector sslConnector(int port) {
        SslContextFactory f = sslContextFactory();
        SslSocketConnector c = new SslSocketConnector(f);
        c.setPort(port);
        return c;
    }

    private SslContextFactory sslContextFactory() {
        SslContextFactory cf = new SslContextFactory("./data/ssl/server.keystore");
        cf.setKeyStorePassword("password");
        return cf;
    }
}
