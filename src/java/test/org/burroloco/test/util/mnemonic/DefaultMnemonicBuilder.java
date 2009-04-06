package org.burroloco.test.util.mnemonic;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import org.burroloco.test.glue.env.EnvPropertyGetter;

public class DefaultMnemonicBuilder implements MnemonicBuilder {
    EnvPropertyGetter prop;

    public String mnemonic(String hostName, StrictMap<String, String> localProps) {
        String mnemonic = safe(hostName, localProps);
        if (mnemonic.length() != 3) throw new IllegalArgumentException("Mnemonic must be of length 3.");
        return mnemonic.toUpperCase();
    }

    private String safe(String hostName, StrictMap<String, String> localProps) {
        try {
            return prop.get(localProps, "local.mnemonic");
        } catch (RuntimeException e) {
            return hostName.substring(0, 3);
        }
    }
}
