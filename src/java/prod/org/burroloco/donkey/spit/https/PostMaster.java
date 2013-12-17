package org.burroloco.donkey.spit.https;

import edge.org.apache.http.client.methods.HttpPost;

public interface PostMaster {
    void addParameter(HttpPost post, String name, String value);
}
