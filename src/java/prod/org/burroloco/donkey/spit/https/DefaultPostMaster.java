package org.burroloco.donkey.spit.https;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.http.client.methods.HttpPost;
import edge.org.apache.http.client.utils.URIBuilder;

import java.net.URI;

public class DefaultPostMaster implements PostMaster {

    Nu nu;

    public void addParameter(HttpPost post, String name, String value) {
        URI before = post.getURI();
        URI after = addParameter(before, name, value);
        post.setURI(after);
    }

    private URI addParameter(URI uri, String name, String value) {
        URIBuilder builder = nu.nu(URIBuilder.class, uri);
        return builder.addParameter(name, value).build();
    }
}
