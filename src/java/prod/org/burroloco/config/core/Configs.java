package org.burroloco.config.core;

import au.net.netstorm.boost.gunge.goop.Nvp;

public interface Configs {
    Config moosh(Config config, Nvp... entries);
}
