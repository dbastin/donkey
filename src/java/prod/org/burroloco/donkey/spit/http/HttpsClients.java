package org.burroloco.donkey.spit.http;

import edge.org.apache.http.client.HttpClient;
import org.burroloco.donkey.config.KeyStoreLocation;
import org.burroloco.donkey.config.KeyStorePassword;

public interface HttpsClients {

    HttpClient nu(KeyStoreLocation l, KeyStorePassword p);
}
