package org.burroloco.butcher.fixture.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.commons.io.IOUtilsStatic;
import edge.org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;

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
        s = nu.nu(Server.class, 8090);
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
        public void handle(String path,
                           HttpServletRequest req,
                           HttpServletResponse resp,
                           int i)
                throws IOException, ServletException {
            byte[] data = io.toByteArray(req.getInputStream());
            String payload = new String(data, "UTF-8");
            requests.add(payload);
            resp.setStatus(SC_OK);
        }
        // }
    }
}
