package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Cake;

public interface HeaderAndBodyProcessor {
    StringBuilder process(Cake cake, StringBuilder stringBuilder);
}
