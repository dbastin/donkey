package org.burroloco.donkey.data.cake;

public interface Bakery {
    String[] KEYS = {"key"};
    Data cake(int start, int end, String flavour);
}
