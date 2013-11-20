package org.burroloco.donkey.slurp.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.javax.servlet.http.HttpServletRequest;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;

import java.util.Enumeration;

public class DefaultHttpRequestConverter implements HttpRequestConverter {
    Nu nu;

    public Data convert(HttpServletRequest request) {
        Data result = nu.nu(Data.class);
        convert(result, request);
        result.readOnly();
        return result;
    }

    private void convert(Data result, HttpServletRequest request) {
        Tuple t = slice(request);
        result.add(t);
    }

    private Tuple slice(HttpServletRequest request) {
        Tuple tuple = nu.nu(Tuple.class);
        addParams(tuple, request);
        tuple.readOnly();
        return tuple;
    }

    private void addParams(Tuple tuple, HttpServletRequest request) {
        Enumeration params = request.getParameterNames();
        while (params.hasMoreElements()) addParam(request, tuple, params);
    }

    private void addParam(HttpServletRequest request, Tuple tuple, Enumeration params) {
        String name = (String) params.nextElement();
        String value = request.getParameter(name);
        tuple.add(name, value);
    }
}
