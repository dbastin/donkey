package org.burroloco.donkey.data.cake;

public interface Bakery {
    // FIX TSR-4239 many many.
    String[] KEYS = {"key"};
    Cake cake(int start, int end, String flavour);
}
