package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.core.Data;

public interface BodyProcessor {
    void process(Data data, StringBuilder stringBuilder);
}
