package org.burroloco.donkey.data.cake;

import java.util.List;
import java.util.Set;

public interface Tuple {
    void add(String name, Object value);

    void addAll(Tuple tuple);

    Object value(String name);

    List<Object> values();

    Set<String> names();
}
