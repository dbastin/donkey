package org.burroloco.donkey.output.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.http.impl.client.DefaultHttpClient;
import edge.org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
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
        HttpGet get = request(config);
        client.execute(get);
    }

    private HttpGet request(Config config) {
        String url = weak.get(config, HttpUrl.class);
        return new HttpGet(url + "?Message=Hello%20World&Date=2009-01-01");
    }
}
