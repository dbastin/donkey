package org.burroloco.donkey.data.cake;

import java.util.List;
import java.util.Set;

public interface Cake {
    void add(Slice slice);
    void addAll(List<Slice> slices);
    void refrigerate();
    List<Slice> slices();
    Set<String> columnNames();
}
