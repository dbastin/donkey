package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Cake;

public interface HeaderProcessor {
    void process(Cake cake, StringBuilder stringBuilder);
}
