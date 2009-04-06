package org.burroloco.test.butcher.exception;

import au.net.netstorm.boost.bullet.primordial.PrimordialException;

public class MissingExpectationException extends PrimordialException {
    public MissingExpectationException(String message) {
        super(message);
    }
}
