package org.burroloco.donkey.spit.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;

import edge.org.apache.http.HttpEntity;
import edge.org.apache.http.client.HttpClient;
import edge.org.apache.http.client.methods.CloseableHttpResponse;
import edge.org.apache.http.client.methods.HttpPost;
import edge.org.apache.http.entity.StringEntity;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.HttpsUrl;
import org.burroloco.donkey.config.KeyStoreLocation;
import org.burroloco.donkey.config.KeyStorePassword;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.spit.core.Spitter;

import java.util.List;

import static org.burroloco.donkey.data.core.Tuple.UNIT_KEY;

public class HttpsSpitter implements Spitter {

    HttpResponseHandler responses;
    HttpsClients clients;
    WeakConfig weak;
    Nu nu;

    public void spit(Config config, Data data) {
        HttpClient client = client(config);
        String url = weak.get(config, HttpsUrl.class);
        List<Tuple> tuples = data.tuples();
        for (Tuple t : tuples) spit(client, t, url, config);
        // TODO - Close the HttpClient.
    }

    private HttpClient client(Config config) {
        KeyStoreLocation l = config.get(KeyStoreLocation.class);
        KeyStorePassword p = config.get(KeyStorePassword.class);
        return clients.nu(l, p);
    }

    private void spit(HttpClient client, Tuple t, String url, Config c) {
        HttpPost request = post(t, url);
        CloseableHttpResponse response = client.execute(request);
        try {
            responses.handle(response, t, c);
        } finally {
            response.close();
        }
    }

    private HttpPost post(Tuple tuple, String url) {
        HttpPost post = nu.nu(HttpPost.class, url);
        setBody(post, tuple);
        return post;
    }

    private void setBody(HttpPost post, Tuple tuple) {
        HttpEntity body = body(tuple);
        post.setEntity(body);
    }

    private HttpEntity body(Tuple tuple) {
        String xmlString = (String) tuple.value(UNIT_KEY);
        return nu.nu(StringEntity.class, xmlString);
    }
}
