package org.burroloco.donkey.error.listener.assistant;

public class DefaultErrorAssistants implements ErrorAssistants {
    private static final ErrorAssistant[] NO_ASSISTANTS = new ErrorAssistant[0];

    public ErrorAssistant[] get() {
        return NO_ASSISTANTS;
    }
}
