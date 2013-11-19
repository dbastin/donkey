package org.burroloco.donkey.spit.http;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.org.apache.http.impl.client.CloseableHttpClient;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.KeyStoreLocation;
import org.burroloco.donkey.config.KeyStorePassword;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.core.TupleSpitter;

import java.util.List;

public class HttpsSpitter implements Spitter {

    HttpsClients clients;
    Nu nu;

    public void spit(Config config, Data data) {
        CloseableHttpClient client = client(config);
        try {
            spit(config, data, client);
        } finally {
            client.close();
        }
    }

    private CloseableHttpClient client(Config config) {
        KeyStoreLocation l = config.get(KeyStoreLocation.class);
        KeyStorePassword p = config.get(KeyStorePassword.class);
        return clients.nu(l, p);
    }

    private void spit(Config config, Data data, CloseableHttpClient client) {
        TupleSpitter spitter = nu.nu(TupleSpitter.class, client);
        List<Tuple> tuples = data.tuples();
        for (Tuple t : tuples) spitter.spit(config, t);
    }
}
