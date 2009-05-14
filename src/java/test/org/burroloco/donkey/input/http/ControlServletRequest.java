package org.burroloco.donkey.input.http;

import edge.javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class ControlServletRequest implements HttpServletRequest {
    private static final String MESSAGE = "Hello World";
    private static final String DATE = "2009-01-01";

    public Enumeration getParameterNames() {
        List list = new ArrayList();
        list.add("Date");
        list.add("Message");
        return Collections.enumeration(list);
    }

    public String getParameter(String s) {
        if (s.equals("Date")) return DATE;
        if (s.equals("Message")) return MESSAGE;
        else throw new IllegalArgumentException(s + " not expected.");
    }
}
