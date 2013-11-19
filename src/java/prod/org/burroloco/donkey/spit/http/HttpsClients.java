package org.burroloco.donkey.spit.http;

import edge.org.apache.http.impl.client.CloseableHttpClient;
import org.burroloco.donkey.config.KeyStoreLocation;
import org.burroloco.donkey.config.KeyStorePassword;

public interface HttpsClients {
    CloseableHttpClient nu(KeyStoreLocation l, KeyStorePassword p);
}
