package org.burroloco.donkey.slurp.http;

import edge.javax.servlet.http.HttpServletRequest;
import org.burroloco.donkey.data.core.Data;

public interface HttpRequestConverter {
    Data convert(HttpServletRequest request);
}
