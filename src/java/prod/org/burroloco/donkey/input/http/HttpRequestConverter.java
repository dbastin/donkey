package org.burroloco.donkey.input.http;

import edge.javax.servlet.http.HttpServletRequest;
import org.burroloco.donkey.data.cake.Cake;

public interface HttpRequestConverter {
    Cake convert(HttpServletRequest request);
}
