package org.burroloco.donkey.error.core;

public class HandledException extends RuntimeException {
    public HandledException(Throwable t) {
        super(t);
    }
}
