package org.burroloco.donkey.data.cake;

public interface Bakery {
    String[] KEYS = {"key"};
    Cake cake(int start, int end, String flavour);
}
