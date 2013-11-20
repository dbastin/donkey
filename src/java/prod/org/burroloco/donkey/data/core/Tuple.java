package org.burroloco.donkey.data.core;

import java.util.List;
import java.util.Set;

public interface Tuple {
    String UNIT_KEY = "UNIT_TUPLE";

    void add(String name, Object value);

    void addAll(Tuple tuple);

    Object value(String name);

    List<Object> values();

    Set<String> names();

    void readOnly();
}
