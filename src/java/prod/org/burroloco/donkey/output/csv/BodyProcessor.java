package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Cake;

public interface BodyProcessor {
    void process(Cake cake, StringBuilder stringBuilder);
}
