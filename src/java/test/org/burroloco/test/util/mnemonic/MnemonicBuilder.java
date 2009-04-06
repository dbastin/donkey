package org.burroloco.test.util.mnemonic;

import au.net.netstorm.boost.gunge.collection.StrictMap;

public interface MnemonicBuilder {
    String mnemonic(String hostName, StrictMap<String, String> localProps);
}
