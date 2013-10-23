package org.burroloco.butcher.fixture.http;

import edge.org.apache.commons.io.IOUtilsStatic;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_OK;

public class StringHandler extends AbstractHandler {

    private List<String> requests = new ArrayList<String>();

    IOUtilsStatic io;

    // OK ThrowsCount {
    public void handle(String s,
                       Request r,
                       HttpServletRequest req,
                       HttpServletResponse resp)
            throws IOException, ServletException {
        String payload = getPayload(req);
        requests.add(payload);
        if (error(req)) handleError(resp);
        else resp.setStatus(SC_OK);
        r.setHandled(true);
    }
    // }

    private String getPayload(HttpServletRequest req) throws IOException {
        ServletInputStream is = req.getInputStream();
        byte[] data = io.toByteArray(is);
        return new String(data, "UTF-8");
    }

    private boolean error(HttpServletRequest req) {
        StringBuffer b = req.getRequestURL();
        String url = b.toString();
        return url.contains("error");
    }

    private void handleError(HttpServletResponse resp) {
        resp.setStatus(SC_INTERNAL_SERVER_ERROR);
    }

    public List<String> getRequests() {
        return requests;
    }
}
