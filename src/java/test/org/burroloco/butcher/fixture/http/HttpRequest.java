package org.burroloco.butcher.fixture.http;

import java.util.HashMap;
import java.util.Map;

public final class HttpRequest {
    Map<String, Object> params = new HashMap<String, Object>();
    String payload;

    public HttpRequest(Map<String, Object> params, String payload) {
        this.params = params;
        this.payload = payload;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public String getPayload() {
        return payload;
    }
}
