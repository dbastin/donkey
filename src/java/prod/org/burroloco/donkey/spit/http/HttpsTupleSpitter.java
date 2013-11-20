package org.burroloco.donkey.spit.http;

import edge.org.apache.http.client.methods.CloseableHttpResponse;
import edge.org.apache.http.client.methods.HttpPost;
import edge.org.apache.http.impl.client.CloseableHttpClient;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.HttpsUrl;
import org.burroloco.donkey.config.KeyStoreLocation;
import org.burroloco.donkey.config.KeyStorePassword;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.spit.core.TupleSpitter;

public class HttpsTupleSpitter implements TupleSpitter {
    HttpResponseHandler responses;
    HttpsClients clients;
    WeakConfig weak;
    HttpPosts posts;

    // TODO - Creating a client once for every tuple? Hmmm...
    public void spit(Config c, Tuple t) {
        CloseableHttpClient client = client(c);
        try {
            spit(c, t, client);
        } finally {
            client.close();
        }
    }

    private CloseableHttpClient client(Config config) {
        KeyStoreLocation l = config.get(KeyStoreLocation.class);
        KeyStorePassword p = config.get(KeyStorePassword.class);
        return clients.nu(l, p);
    }

    private void spit(Config c, Tuple t, CloseableHttpClient client) {
        String url = weak.get(c, HttpsUrl.class);
        HttpPost request = posts.nu(t, url);
        post(client, request, c, t);
    }

    private void post(CloseableHttpClient client, HttpPost request, Config c, Tuple t) {
        CloseableHttpResponse response = client.execute(request);
        try {
            responses.handle(response, t, c);
        } finally {
            response.close();
        }
    }
}
