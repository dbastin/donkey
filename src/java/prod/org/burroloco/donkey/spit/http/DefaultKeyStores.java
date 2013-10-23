package org.burroloco.donkey.spit.http;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.io.FileInputStream;
import edge.java.security.KeyStore;
import edge.java.security.KeyStoreStatic;
import org.burroloco.donkey.config.KeyStoreLocation;
import org.burroloco.donkey.config.KeyStorePassword;

import java.io.File;

public class DefaultKeyStores implements KeyStores {

    KeyStoreStatic keyStore;
    Weaken weaken;
    Nu nu;

    public KeyStore nu(KeyStoreLocation l, KeyStorePassword p) {
        KeyStore result = nu();
        load(result, l, p);
        return result;
    }

    private void load(KeyStore result, KeyStoreLocation l, KeyStorePassword p) {
        FileInputStream s = toInputStream(l);
        try {
            result.load(s, toCharArray(p));
        } finally {
            s.close();
        }
    }

    private FileInputStream toInputStream(KeyStoreLocation l) {
        File file = toFile(l);
        return nu.nu(FileInputStream.class, file);
    }

    private File toFile(KeyStoreLocation l) {
        String location = weaken.w(l);
        return new File(location);
    }

    private KeyStore nu() {
        String type = keyStore.getDefaultType();
        return keyStore.getInstance(type);
    }

    private char[] toCharArray(KeyStorePassword p) {
        String password = weaken.w(p);
        return password.toCharArray();
    }
}
