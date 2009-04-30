package org.burroloco.donkey.input.http;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.HttpMessage;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.transformation.gargler.Gargler;
import au.net.netstorm.boost.spider.api.runtime.Nu;

public class DefaultHttpRequestHandler implements HttpRequestHandler {
    private final Config config;
    HttpRequestConverter converter;
    Gargler gargler;
    Nu nu;

    public DefaultHttpRequestHandler(Config config) {
        this.config = config;
    }

    public void handleRequest(String request) {
        Cake cake = converter.convert(nu.nu(HttpMessage.class, request));
        gargler.slosh(config, cake);
    }
}
