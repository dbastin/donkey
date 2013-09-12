package org.burroloco.donkey.input.csv;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.config.InputFileName;
import org.burroloco.donkey.data.cake.Data;
import org.burroloco.donkey.input.core.Slurper;

public class CsvSlurper implements Slurper {
    CsvSlurperEngine engine;
    
    public Data slurp(Config config) {
        InputFileName in = config.get(InputFileName.class);
        return engine.slurp(in);
    }
}
