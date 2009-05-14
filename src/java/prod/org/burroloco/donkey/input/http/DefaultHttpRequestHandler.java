package org.burroloco.donkey.input.http;

import edge.javax.servlet.http.HttpServletRequest;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.log.ProcessLogger;
import org.burroloco.donkey.transformation.gargler.Gargler;

public class DefaultHttpRequestHandler implements HttpRequestHandler {
    private final Config config;
    HttpRequestConverter converter;
    ProcessLogger logger;
    Gargler gargler;

    public DefaultHttpRequestHandler(Config config) {
        this.config = config;
    }

    public void handle(HttpServletRequest request) {
        logger.logStarted();
        Cake cake = converter.convert(request);
        gargler.slosh(config, cake);
        logger.logFinished();
    }
}
