package org.burroloco.donkey.data.error;

import au.net.netstorm.boost.bullet.primordial.PrimordialException;

public class DuplicateColumnException extends PrimordialException {
    public DuplicateColumnException(String name) {
        super("Value for '" + name + "' already set");
    }
}
