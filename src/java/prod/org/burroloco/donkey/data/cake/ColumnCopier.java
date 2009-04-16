package org.burroloco.donkey.data.cake;

public interface ColumnCopier {
    void copy(Slice in, Slice out, String... names);
}