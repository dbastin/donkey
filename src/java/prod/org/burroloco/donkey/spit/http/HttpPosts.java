package org.burroloco.donkey.spit.http;

import edge.org.apache.http.client.methods.HttpPost;
import org.burroloco.donkey.data.core.Tuple;

public interface HttpPosts {
    HttpPost nu(Tuple t, String url);
}
