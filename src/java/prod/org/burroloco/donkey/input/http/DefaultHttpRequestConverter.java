package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.javax.servlet.http.HttpServletRequest;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.util.date.Dates;

import java.util.Enumeration;

public class DefaultHttpRequestConverter implements HttpRequestConverter {
    Weaken weaken;
    Dates dates;
    Nu nu;

    public Cake convert(HttpServletRequest request) {
        Cake out = nu.nu(Cake.class);
        out.add(slice(request));
        return out;
    }

    private Slice slice(HttpServletRequest request) {
        Slice slice = nu.nu(Slice.class);
        Enumeration params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String name = (String) params.nextElement();
            String value = request.getParameter(name);
            slice.add(name, value);
        }
        slice.add("Date", dates.now());
        return slice;
    }
}
