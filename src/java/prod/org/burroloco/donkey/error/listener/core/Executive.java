package org.burroloco.donkey.error.listener.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.listener.assistant.ErrorAssistant;

public interface Executive {
    void ignore(Config config, ErrorAssistant assistant);
}
