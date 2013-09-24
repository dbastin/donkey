package org.burroloco.donkey.slurp.csv;

import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.core.Data;

public interface CsvSlurperEngine {
    Data slurp(InputFileName in);
}
