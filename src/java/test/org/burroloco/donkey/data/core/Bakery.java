package org.burroloco.donkey.data.core;

public interface Bakery {
    String[] KEYS = {"key"};
    Data cake(int start, int end, String flavour);
}
