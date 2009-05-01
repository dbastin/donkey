package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.bullet.scalpel.core.Edges;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.javax.servlet.http.HttpServletRequest;
import org.burroloco.config.core.Config;
import org.mortbay.jetty.handler.AbstractHandler;

import javax.servlet.ServletException;
import java.io.IOException;

public class EdgeRequestHandler extends AbstractHandler {
    private Config config;
    Edges edges;
    Nu nu;

    public EdgeRequestHandler(Config config) {
        this.config = config;
    }

    // OK ThrowsCount {
    public void handle(String target,
                       javax.servlet.http.HttpServletRequest request,
                       javax.servlet.http.HttpServletResponse response,
                       int dispatch) throws IOException, ServletException {
        HttpRequestHandler delegate = nu.nu(HttpRequestHandler.class, config);
        delegate.handle(edge(request));
    }
    // } ThrowsCount

    private HttpServletRequest edge(javax.servlet.http.HttpServletRequest request) {
        return edges.edge(HttpServletRequest.class, request);
    }
}
