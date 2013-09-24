package org.burroloco.donkey.spit.csv;

import org.burroloco.donkey.data.core.Data;

public interface HeaderProcessor {
    void process(Data data, StringBuilder stringBuilder);
}
