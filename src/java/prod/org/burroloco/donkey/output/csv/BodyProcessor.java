package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Data;

public interface BodyProcessor {
    void process(Data data, StringBuilder stringBuilder);
}
