package org.burroloco.donkey.data.error;

// FIX TSR-DONKEY Use or Lose
public class MissingValueException extends RuntimeException {
    public MissingValueException(String name) {
        super("There is no key '" + name + "'");
    }
}
