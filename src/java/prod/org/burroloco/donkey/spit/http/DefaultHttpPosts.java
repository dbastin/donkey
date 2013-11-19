package org.burroloco.donkey.spit.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.http.HttpEntity;
import edge.org.apache.http.client.methods.HttpPost;
import edge.org.apache.http.entity.StringEntity;
import org.burroloco.donkey.data.core.Tuple;

import static org.burroloco.donkey.data.core.Tuple.UNIT_KEY;

public class DefaultHttpPosts implements HttpPosts {
    Nu nu;

    public HttpPost nu(Tuple tuple, String url) {
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
