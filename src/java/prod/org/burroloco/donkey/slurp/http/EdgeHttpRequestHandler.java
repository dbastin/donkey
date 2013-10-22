package org.burroloco.donkey.slurp.http;

import au.net.netstorm.boost.bullet.scalpel.core.Edges;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.javax.servlet.http.HttpServletRequest;
import org.burroloco.config.core.Config;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EdgeHttpRequestHandler extends AbstractHandler {
    private Config config;
    Edges edges;
    Nu nu;

    public EdgeHttpRequestHandler(Config config) {
        this.config = config;
    }

    // OK ThrowsCount {
    public void handle(String s,
                       Request r,
                       javax.servlet.http.HttpServletRequest req,
                       HttpServletResponse resp)
            throws IOException, ServletException {
        HttpRequestHandler delegate = nu.nu(HttpRequestHandler.class, config);
        delegate.handle(edge(req));
    }
    // } ThrowsCount

    private HttpServletRequest edge(javax.servlet.http.HttpServletRequest request) {
        return edges.ref(HttpServletRequest.class, request);
    }

}
