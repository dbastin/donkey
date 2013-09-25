package org.burroloco.donkey.data.core;

public final class Null {
    public static final Null NULL = new Null();

    private Null() {
    }

    // TODO - Change this to be something more obvious! Sheeesh.
    public String toString() {
        return "null";
    }

    public boolean equals(Object obj) {
        return obj instanceof Null;
    }

    public int hashCode() {
        return 42;
    }
}
