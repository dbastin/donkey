package org.burroloco.donkey.spit.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.security.KeyStore;
import edge.javax.net.ssl.SSLContext;
import edge.org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import edge.org.apache.http.conn.ssl.SSLContextBuilder;
import edge.org.apache.http.conn.ssl.SSLContextsStatic;
import edge.org.apache.http.impl.client.CloseableHttpClient;
import edge.org.apache.http.impl.client.HttpClientBuilder;
import edge.org.apache.http.impl.client.HttpClientsStatic;
import org.burroloco.donkey.config.KeyStoreLocation;
import org.burroloco.donkey.config.KeyStorePassword;

import static org.apache.http.conn.ssl.SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;

public class DefaultHttpsClients implements HttpsClients {

    SSLContextsStatic sslContexts;
    HttpClientsStatic httpClients;
    KeyStores keystores;
    Nu nu;

    public CloseableHttpClient nu(KeyStoreLocation l, KeyStorePassword p) {
        SSLConnectionSocketFactory f = socketFactory(l, p);
        HttpClientBuilder builder = httpClients.custom();
        return builder.setSSLSocketFactory(f).build();
    }

    private SSLConnectionSocketFactory socketFactory(KeyStoreLocation l, KeyStorePassword p) {
        SSLContext sslcontext = context(l, p);
        return nu.nu(SSLConnectionSocketFactory.class, sslcontext, BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    private SSLContext context(KeyStoreLocation l, KeyStorePassword p) {
        SSLContextBuilder builder = builder(l, p);
        return builder.build();
    }

    private SSLContextBuilder builder(KeyStoreLocation l, KeyStorePassword p) {
        KeyStore keyStore = keystores.nu(l, p);
        SSLContextBuilder b = sslContexts.custom();
        return b.loadTrustMaterial(keyStore);
    }
}
