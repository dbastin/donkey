package org.burroloco.donkey.error.job;

public class HandledException extends RuntimeException {
    public HandledException(Throwable t) {
        super(t);
    }
}
