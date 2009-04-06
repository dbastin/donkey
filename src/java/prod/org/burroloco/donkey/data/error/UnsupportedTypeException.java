package org.burroloco.donkey.data.error;

import au.net.netstorm.boost.bullet.primordial.PrimordialException;

public class UnsupportedTypeException extends PrimordialException {
    public UnsupportedTypeException(String message) {
        super(message);
    }
}
