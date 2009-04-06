package org.burroloco.donkey.error.listener.core;

import org.burroloco.config.core.Config;

public interface ErrorEventListener {
    void onError(Config config);
}
