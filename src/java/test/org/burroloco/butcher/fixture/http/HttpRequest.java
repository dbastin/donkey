package org.burroloco.butcher.fixture.http;

import au.net.netstorm.boost.bullet.primordial.Primordial;

import java.util.HashMap;
import java.util.Map;

public final class HttpRequest extends Primordial {
    Map<String, String> params = new HashMap<String, String>();
    String payload;

    public HttpRequest(Map<String, String> params, String payload) {
        this.params = params;
        this.payload = payload;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public String getPayload() {
        return payload;
    }
}
