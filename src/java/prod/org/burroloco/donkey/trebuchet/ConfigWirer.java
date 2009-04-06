package org.burroloco.donkey.trebuchet;

import org.burroloco.config.core.Config;

public interface ConfigWirer {
    void wire(Config config, Class<? extends Wirer> cls);
}
