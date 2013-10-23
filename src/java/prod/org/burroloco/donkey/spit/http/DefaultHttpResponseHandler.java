package org.burroloco.donkey.spit.http;

import au.net.netstorm.boost.bullet.log.Log;
import edge.org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.ErrorDirName;
import org.burroloco.donkey.data.core.Tuple;

public class DefaultHttpResponseHandler implements HttpResponseHandler {

    HttpErrorHandler errors;
    Log log;

    public void handle(HttpResponse response, Tuple t, Config c) {
        int status = statusCode(response);
        // TODO - AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA - Getting 404s every time! Fix.
        handleError(t, c, status);
//        if (!ok(status)) handleError(t, c, status);
//        else consume(response);
    }

    private int statusCode(HttpResponse response) {
        StatusLine l = response.getStatusLine();
        log.info(l.toString());
        return l.getStatusCode();
    }

    private void handleError(Tuple t, Config c, int status) {
        ErrorDirName dir = c.get(ErrorDirName.class);
        errors.handle(t, status, dir);
    }

//    private void consume(HttpResponse response) {
//        HttpEntity entity = response.getEntity();
//        entity.consumeContent();
//    }
//
//    private boolean ok(int status) {
//        return status == SC_OK;
//    }
}
