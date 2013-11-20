package org.burroloco.donkey.data.core;

import java.util.List;
import java.util.Set;

public interface Data {
    void add(Tuple tuple);
    void addAll(List<Tuple> tuples);
    void readOnly();
    List<Tuple> tuples();
    Set<String> names();
}
