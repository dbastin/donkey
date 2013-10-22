package org.burroloco.butcher.fixture.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.commons.io.IOUtilsStatic;
import edge.org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.servlet.http.HttpServletResponse.SC_OK;

public class DefaultTargetHttpServer implements TargetHttpServer {

    private List<String> requests = new ArrayList<String>();
    private Server s;

    IOUtilsStatic io;
    Nu nu;

    public void start() {
        s = nu.nu(Server.class, 8030);
        s.setHandler(new StringHandler());
        s.start();
    }

    public List<String> requests() {
        return requests;
    }

    public void stop() {
        s.stop();
    }

    private class StringHandler extends AbstractHandler {
        // OK ThrowsCount {
        public void handle(String s,
                           Request r,
                           HttpServletRequest req,
                           HttpServletResponse resp)
                throws IOException, ServletException {
            String payload = getPayload(req);
            requests.add(payload);
            resp.setStatus(SC_OK);
        }
        // }

        private String getPayload(HttpServletRequest req) throws IOException {
            byte[] data = io.toByteArray(req.getInputStream());
            return new String(data, "UTF-8");
        }
    }
}
