package org.burroloco.donkey.output.csv;

import org.burroloco.donkey.data.cake.Cake;

public interface CsvStringer {
    String text(Cake cake);
}
