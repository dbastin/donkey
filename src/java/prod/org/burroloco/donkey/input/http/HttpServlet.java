package org.burroloco.donkey.input.http;

import edge.javax.servlet.http.HttpServletRequest;

public interface HttpServlet {
    void handleRequest(HttpServletRequest request);
}
