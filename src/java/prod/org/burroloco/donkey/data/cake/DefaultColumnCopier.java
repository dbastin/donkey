package org.burroloco.donkey.data.cake;

// FIX TSR-DONKEY Use or Lose
public class DefaultColumnCopier implements ColumnCopier {
    public void copy(Slice in, Slice out, String... names) {
        for (String name : names) out.add(name, in.value(name));
    }
}