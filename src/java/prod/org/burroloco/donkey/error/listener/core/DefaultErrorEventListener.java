package org.burroloco.donkey.error.listener.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.error.listener.assistant.ErrorAssistant;
import org.burroloco.donkey.error.listener.assistant.ErrorAssistants;

public class DefaultErrorEventListener implements ErrorEventListener {
    ErrorAssistants errorAssistants;
    Executive executive;

    public void onError(Config config) {
        callAssistants(config);
    }

    private void callAssistants(Config config) {
        ErrorAssistant[] assistants = errorAssistants.get();
        for (ErrorAssistant assistant : assistants) {
            executive.ignore(config, assistant);
        }
    }
}
