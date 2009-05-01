// DEBT IllegalRegexp|NCSS|ThrowsCount|FileLength {}
// Adapted from: http://triton.towson.edu/~schmitt/server/servlet/SnoopServlet.java
package org.burroloco.donkey.input.http;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class SnoopServlet extends HttpServlet {
    private String prefix = "";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doService(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doService(request, response);
    }

    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><title>Snoop</title><form method=post action=" + prefix + request.getRequestURI() + ">");
        out.print("<p><center><b><FONT SIZE=+2>SnoopServlet</FONT></b></center>");
        showCookies(request, out);
        showHeaders(request, out);
        showMethod(request, out);
        showParams(request, out);
        showPathInfo(request, out);
        showPathTranslate(request, out);
        showQuery(request, out);
        showRequestURI(request, out);
        showServletPath(request, out);
        out.print("</form></html>");
    }

    private void showCookies(HttpServletRequest request, PrintWriter out) {
        out.print("<p><b>Cookies</b><br>");
        out.print("<table border=1 >");
        out.print("<tr><th>Name</th><th>Value</th></tr>");
        System.out.println("**Cookies**");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cooky : cookies) outrow(out, cooky.getName(), cooky.getValue());
        }
        out.print("</table>");
    }

    private void showHeaders(HttpServletRequest request, PrintWriter out) {
        outpb(out, "Request Headers");
        out.print("<table border=1> <tr> <th>Name</th> <th>Value</th> </tr>");
        Enumeration headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String name = (String) headers.nextElement();
            String value = request.getHeader(name);
            outrow(out, name, value);
        }
        out.print("</table>");
    }

    private void showMethod(HttpServletRequest request, PrintWriter out) {
        outpb(out, "Method");
        out(out, "Method: " + request.getMethod());
        out.print("<br> <input type=submit name=Submit value=Submit> <br>");
    }

    private void showParams(HttpServletRequest request, PrintWriter out) {
        outpb(out, "Request Parameters");
        out.print("<table border=1> <tr> <th>Name</th> <th>Value</th> </tr>");
        Enumeration params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String name = (String) params.nextElement();
            String value = request.getParameter(name);
            outrow(out, name, value);
        }
        out.print("</table>");
    }

    private void showPathInfo(HttpServletRequest request, PrintWriter out) {
        outpb(out, "Path Info");
        out(out, "Path Info: " + request.getPathInfo());
    }

    private void showPathTranslate(HttpServletRequest request, PrintWriter out) {
        outpb(out, "Path Translated");
        out(out, "Path Translated: " + request.getPathTranslated());
    }

    private void showQuery(HttpServletRequest request, PrintWriter out) {
        outpb(out, "Query String");
        out(out, "Query String: " + request.getQueryString());
    }

    private void showRequestURI(HttpServletRequest request, PrintWriter out) {
        outpb(out, "Request URI");
        out(out, "Request URI: " + request.getRequestURI());
    }

    private void showServletPath(HttpServletRequest request, PrintWriter out) {
        outpb(out, "Servlet Path");
        out(out, "Servlet Path: " + request.getServletPath());
    }

    private void outpb(PrintWriter out, String msg) {
        out.print("<p><b>" + msg + "</b><br>");
        System.out.println("**" + msg + "**");
    }

    private void out(PrintWriter out, String msg) {
        out.print(msg);
        System.out.println(msg);
    }

    private void outrow(PrintWriter out, String name, String value) {
        out.print("<tr><td>" + name + "</td><td>" + value + "</td><tr>");
        System.out.println(name + ": " + value);
    }

}
