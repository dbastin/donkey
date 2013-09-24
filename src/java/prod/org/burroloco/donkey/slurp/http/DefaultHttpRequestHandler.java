package org.burroloco.donkey.slurp.http;

import edge.javax.servlet.http.HttpServletRequest;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.log.ProcessLogger;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.gargle.DataGargler;

public class DefaultHttpRequestHandler implements HttpRequestHandler {
    private final Config config;
    HttpRequestConverter converter;
    ProcessLogger logger;
    DataGargler gargler;
    Spitter spitter;

    public DefaultHttpRequestHandler(Config config) {
        this.config = config;
    }

    public void handle(HttpServletRequest request) {
        logger.logStarted();
        Data in = converter.convert(request);
        Data out = gargler.gargle(config, in);
        spitter.spit(config, out);
        logger.logFinished();
    }
}
