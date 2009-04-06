package org.burroloco.donkey.data.error;

public class MissingValueException extends RuntimeException {
    public MissingValueException(String name) {
        super("There is no key '" + name + "'");
    }
}
