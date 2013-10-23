package org.burroloco.donkey.spit.http;

import edge.java.security.KeyStore;
import org.burroloco.donkey.config.KeyStoreLocation;
import org.burroloco.donkey.config.KeyStorePassword;

public interface KeyStores {
    KeyStore nu(KeyStoreLocation l, KeyStorePassword p);
}
