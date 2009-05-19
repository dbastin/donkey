package org.burroloco.donkey.synchronator;

import org.burroloco.config.core.Config;

public interface Synchronator {
    void sync(Subject s, Config c);
}
