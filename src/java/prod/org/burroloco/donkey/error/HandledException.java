package org.burroloco.donkey.error;

public class HandledException extends RuntimeException {
    public HandledException(Throwable t) {
        super(t);
    }
}
