package org.burroloco.donkey.data.core;

public interface DataGenerator {
    String[] KEYS = {"key"};
    Data data(int start, int end, String value);
}
