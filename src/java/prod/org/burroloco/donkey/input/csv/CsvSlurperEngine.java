package org.burroloco.donkey.input.csv;

import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.cake.Cake;

public interface CsvSlurperEngine {
    Cake slurp(InputFileName in);
}
