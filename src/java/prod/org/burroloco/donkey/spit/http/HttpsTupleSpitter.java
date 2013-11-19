package org.burroloco.donkey.spit.http;

import edge.org.apache.http.client.HttpClient;
import edge.org.apache.http.client.methods.CloseableHttpResponse;
import edge.org.apache.http.client.methods.HttpPost;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.HttpsUrl;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.spit.core.TupleSpitter;

public class HttpsTupleSpitter implements TupleSpitter {
    private final HttpClient client;

    HttpResponseHandler responses;
    WeakConfig weak;
    HttpPosts posts;

    public HttpsTupleSpitter(HttpClient client) {
        this.client = client;
    }

    public void spit(Config c, Tuple t) {
        String url = weak.get(c, HttpsUrl.class);
        HttpPost request = posts.nu(t, url);
        post(request, c, t);
    }

    private void post(HttpPost request, Config c, Tuple t) {
        CloseableHttpResponse response = client.execute(request);
        try {
            responses.handle(response, t, c);
        } finally {
            response.close();
        }
    }
}
