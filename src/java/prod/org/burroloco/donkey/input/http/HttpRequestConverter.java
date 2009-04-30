package org.burroloco.donkey.input.http;

import org.burroloco.donkey.config.HttpMessage;
import org.burroloco.donkey.data.cake.Cake;

public interface HttpRequestConverter {
    Cake convert(HttpMessage request);
}
