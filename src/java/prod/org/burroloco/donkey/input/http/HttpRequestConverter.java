package org.burroloco.donkey.input.http;

import edge.javax.servlet.http.HttpServletRequest;
import org.burroloco.donkey.data.cake.Data;

public interface HttpRequestConverter {
    Data convert(HttpServletRequest request);
}
