package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.javax.servlet.http.HttpServletRequest;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;

import java.util.Enumeration;

public class DefaultHttpRequestConverter implements HttpRequestConverter {
    Nu nu;

    public Data convert(HttpServletRequest request) {
        Data out = nu.nu(Data.class);
        out.add(slice(request));
        return out;
    }

    private Tuple slice(HttpServletRequest request) {
        Tuple tuple = nu.nu(Tuple.class);
        Enumeration params = request.getParameterNames();
        while (params.hasMoreElements()) {
            add(request, tuple, params);
        }
        return tuple;
    }

    private void add(HttpServletRequest request, Tuple tuple, Enumeration params) {
        String name = (String) params.nextElement();
        String value = request.getParameter(name);
        tuple.add(name, value);
    }
}
