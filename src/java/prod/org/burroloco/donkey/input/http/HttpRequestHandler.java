package org.burroloco.donkey.input.http;

import edge.javax.servlet.http.HttpServletRequest;

public interface HttpRequestHandler {
    void handle(HttpServletRequest request);
}
