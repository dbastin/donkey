package org.burroloco.donkey.slurp.http;

import edge.javax.servlet.http.HttpServletRequest;

public interface HttpRequestHandler {
    void handle(HttpServletRequest request);
}
