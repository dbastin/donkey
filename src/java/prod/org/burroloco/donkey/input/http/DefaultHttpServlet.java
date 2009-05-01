package org.burroloco.donkey.input.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.javax.servlet.http.HttpServletRequest;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.transformation.gargler.Gargler;

public class DefaultHttpServlet implements HttpServlet {
    private final Config config;
    HttpRequestConverter converter;
    Gargler gargler;
    Nu nu;

    public DefaultHttpServlet(Config config) {
        this.config = config;
    }

    public void handleRequest(HttpServletRequest request) {
        Cake cake = converter.convert(request);
        gargler.slosh(config, cake);
    }
}
