package edge.org.apache.http.client.utils;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.net.URI;

public interface URIBuilder extends Edge {
    URIBuilder addParameter(String param, String value);

    URI build();
}
