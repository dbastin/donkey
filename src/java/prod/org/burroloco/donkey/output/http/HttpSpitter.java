package org.burroloco.donkey.output.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.http.client.HttpClient;
import edge.org.apache.http.impl.client.DefaultHttpClient;
import edge.org.apache.http.HttpEntity;
import edge.org.apache.http.client.methods.HttpPost;
import edge.org.apache.http.entity.StringEntity;
import org.burroloco.config.core.Config;
import org.burroloco.config.core.WeakConfig;
import org.burroloco.donkey.config.HttpUrl;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.output.core.Spitter;

public class HttpSpitter implements Spitter {

    WeakConfig weak;
    Nu nu;

    public void spit(Config config, Data data) {
        HttpClient client = nu.nu(DefaultHttpClient.class);
        HttpPost post = post(config, data);
        client.execute(post);
    }

    private HttpPost post(Config config, Data data) {
        String url = weak.get(config, HttpUrl.class);
        HttpPost post = nu.nu(HttpPost.class, url);
        HttpEntity body = body(data);
        post.setEntity(body);
        return post;
    }

    // TODO - Put the data into the entity...
    private HttpEntity body(Data data) {
        return nu.nu(StringEntity.class, "<employee></employee>");
    }
}
