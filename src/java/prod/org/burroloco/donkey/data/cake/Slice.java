package org.burroloco.donkey.data.cake;

import java.util.List;
import java.util.Set;

public interface Slice {
    void add(String name, Object value);

    void addAll(Slice slice);

    Object value(String name);

    List<Object> values();

    Set<String> names();
}
