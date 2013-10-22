package org.burroloco.donkey.spit.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.http.HttpEntity;
import edge.org.apache.http.HttpResponse;
import edge.org.apache.http.client.HttpClient;
import edge.org.apache.http.client.methods.HttpPost;
import edge.org.apache.http.entity.StringEntity;
import edge.org.apache.http.impl.client.DefaultHttpClient;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.HttpUrl;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.spit.core.Spitter;

import java.util.List;

import static org.burroloco.donkey.data.core.Tuple.UNIT_KEY;

public class HttpSpitter implements Spitter {

    WeakConfig weak;
    Nu nu;

    public void spit(Config config, Data data) {
        HttpClient client = nu.nu(DefaultHttpClient.class);
        String url = weak.get(config, HttpUrl.class);
        List<Tuple> tuples = data.tuples();
        for (Tuple t : tuples) spit(client, t, url);
    }

    // TODO - Error handling.
    private void spit(HttpClient client, Tuple t, String url) {
        HttpPost request = post(t, url);
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        entity.consumeContent();
        // TODO - Close the response?
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
