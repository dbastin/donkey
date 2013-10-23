package org.burroloco.donkey.spit.http;

import edge.org.apache.http.HttpResponse;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Tuple;

public interface HttpResponseHandler {

    void handle(HttpResponse response, Tuple t, Config c);
}
