package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.bullet.scalpel.core.Edges;

import javax.servlet.ServletException;
import java.io.IOException;

public class EdgeHttpServlet extends javax.servlet.http.HttpServlet {
    // HttpServlet delegate;
    Edges edger;

    // OK ThrowsCount {
    public void doPost(javax.servlet.http.HttpServletRequest request,
                       javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        // FIX TSR-DONKEY Implement...
//        delegate.doPost(edge(request), edge(response));
    }
    // } ThrowsCount

//    private HttpServletRequest edge(javax.servlet.http.HttpServletRequest request) {
//        return edger.edge(HttpServletRequest.class, request);
//    }
//
//    private HttpServletResponse edge(javax.servlet.http.HttpServletResponse response) {
//        return edger.edge(HttpServletResponse.class, response);
//    }
}